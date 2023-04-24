package vn.codegym.repository.product;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.multipart.MultipartFile;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.entity.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where code like concat('%', :code, '%') " +
            "and qrimg like concat('%', :qrImg, '%')", nativeQuery = true)
    List<Product> findProductWithCode(Pageable pageable,
                                      @Param("code") String code,
                                      @Param("qrImg") String qrImg);
    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product findWithId(@Param("id") Integer id);

    @Query(value = "SELECT p.product_id, p.product_code, p.product_name, ps.name as size, psd.quantity, p.product_entry_price, p.product_entry_price * 3 as selling_price, p.product_img, p.product_qr_img "
            + "FROM product p "
            + "JOIN product_size_detail psd ON p.product_id = psd.product_id "
            + "JOIN product_size ps ON psd.size_id = ps.product_id "
            + "WHERE p.is_deleted = false "
            + "ORDER BY p.product_id, psd.size_id", nativeQuery = true)
    Page<ProductDTO> findAllProducts(Pageable pageable);

    @Query(value = "SELECT p.id, p.code, p.name, ps.size, ps.quantity, p.entry_price, p.entry_price * 3 as selling_price, p.img, p.qr_img "
            + "FROM product p JOIN product_size ps ON p.id = ps.id "
            + "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :productName, '%')) "
            + "AND (:productSizeList is null or ps.size in :productSizeList) "
            + "AND p.product_type_id = :productTypeId AND p.is_deleted = false", nativeQuery = true)
    Page<ProductDTO> search(@Param("name") String productName,
                            @Param("productSizeList") List<String> productSizeList,
                            @Param("productTypeId") Integer productTypeId,
                            Pageable pageable);

    @Query(value = "SELECT p.id, p.code, p.name, ps.size, ps.quantity, p.entry_price, p.entry_price * 3 as selling_price, p.img, p.qr_img "
            + "FROM product p JOIN product_size ps ON p.id = ps.id "
            + "WHERE p.id = :productId AND p.is_deleted = false", nativeQuery = true)
    Optional<Product> findById(@Param("productId") Integer productId);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO product (code,name, img,qr_img,entry_price, product_type_id) " +
            "VALUES (:productCode, :productName, :productImg, :productQrImg, :productEntryPrice, :productTypeId)", nativeQuery = true)
    void addProduct(@Param("code") String productCode,
                    @Param("name") String productName,
                    @Param("img") MultipartFile productImg,
                    @Param("qrImg") String productQrImg,
                    @Param("entryPrice") Double productEntryPrice,
                    @Param("productTypeId") Integer productTypeId);



    @Transactional
    @Modifying
    @Query(value = "INSERT INTO product_size (id, size, quantity) " +
            "VALUES (:productId, :size, :quantity)", nativeQuery = true)
    void addProductSize(@Param("productId") Integer productId,
                        @Param("size") String size,
                        @Param("quantity") Integer quantity);
}
