package vn.codegym.repository.product;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.multipart.MultipartFile;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.dto.product.ProductDetailDTO;

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


    /**
     * Created by : QuanTVA
     * @param id
     * @return : List<ProductDetailDTO>
     *  Function : findAllByIdProduct
     */
    @Query(value = "select p.code as code ,p.name as name ,psd.quantity as quantity,ps.name as size \n" +
            "from product p \n" +
            "join product_size_detail psd on p.id = psd.product_id \n" +
            "join product_size ps on psd.product_size_id = ps.id \n" +
            "WHERE p.is_delete = false \n" +
            "and \n" +
            "p.id = :id ; ", nativeQuery = true)
    List<ProductDetailDTO> findAllByIdProduct(@Param("id") int id);

    /**
     * created by : QuanTVA
     * @param pageable
     * @return : Page<Product>
     *     function : findAllProduct
     */
    @Query(value = "select * from product where product.is_delete=false" , nativeQuery = true)
    Page<Product> findAllProducts(Pageable pageable);

    /**
     *created by : QuanTVA
     * @param productName
     * @param productSizeList
     * @param productTypeId
     * @param pageable
     * @return Page<ProductDTO>
     *     Function : search
     */
    @Query(value = "SELECT p.id, p.code, p.name, ps.size, ps.quantity, p.entry_price, p.entry_price * 3 as selling_price, p.img, p.qr_img "
            + "FROM `product` p JOIN `product_size` ps ON p.id = ps.product_id "
            + "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :productName, '%')) "
            + "AND (:productSizeList is null or ps.size in :productSizeList) "
            + "AND p.product_type_id = :productTypeId AND p.is_delete = false", nativeQuery = true)
    Page<ProductDTO> search(@Param("productName") String productName,
                            @Param("productSizeList") List<String> productSizeList,
                            @Param("productTypeId") Integer productTypeId,
                            Pageable pageable);


    /**
     * created by QuanTVA
     * @param code
     * @param name
     * @param img
     * @param qrImg
     * @param entryPrice
     * @param productTypeId
     * function : addProduct
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO product (code,`name`, img,qr_img,entry_price,selling_price, product_type_id,is_delete) " +
            "VALUES (:code, :name, :img, :qrImg, :entryPrice, :sellingPrice ,:productTypeId, :isDelete)", nativeQuery = true)
    void addProduct(@Param("code") String code,
                    @Param("name") String name,
                    @Param("img") String img,
                    @Param("qrImg") String qrImg,
                    @Param("entryPrice") Double entryPrice,
                    @Param("sellingPrice") Double sellingPrice,
                    @Param("productTypeId") Integer productTypeId,
                    @Param("isDelete") boolean isDelete);

    /**
     * create by QuanTVA
     * @param idSize
     * @param idProduct
     * function addProductSizeDetail
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `fashion_shop`.`product_size_detail`" +
            " (`product_id`, `product_size_id`) VALUES (:idProduct, :idSize);", nativeQuery = true)
    void addProductSizeDetail(@Param("idSize") Integer idSize,
                                @Param("idProduct")Integer idProduct);

    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function: connect service to get data corresponding to the search data
     *
     * @param name
     * @param product_type_id
     * @return
     */

    @Query(value = "select * from product join product_type pt on product.product_type_id = pt.id where pt.id = coalesce(nullif(:id,0), pt.id) and product.name like CONCAT('%' :name '%')", nativeQuery = true)
    Page<Product> ListProduct(@Param("name") String name, @Param("id") Integer product_type_id, Pageable pageable);



    @Query(value = "select * from product where qr_img = :qrImg", nativeQuery = true)
    Product findWithQr(@Param("qrImg") String qrImg);
    @Query(value = "select * from product where code = :code", nativeQuery = true)
    Product findWithCode(@Param("code") String code);

    @Query(value = "select count(code) from product", nativeQuery = true)
    Integer getTotalCodeAmount();
}

