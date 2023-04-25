package vn.codegym.repository.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.product.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductSizeRepository extends JpaRepository<ProductSize, Integer> {
    /**
     * created by QuanTVA
     * @param pageable the pageable to request a paged result, can be {@link Pageable#unpaged()}, must not be
     *          {@literal null}.
     * @return Page<ProductSize>
     */
    @Query(value = "SELECT * FROM product_size WHERE is_deleted = false", nativeQuery = true)
    Page<ProductSize> findAll(Pageable pageable);

    /**
     * created by QuanTVA
     * @param sizeName
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM product_size WHERE LOWER(size_name) LIKE LOWER(CONCAT('%', :sizeName, '%')) AND is_deleted = false", nativeQuery = true)
    Page<ProductSize> search(@Param("sizeName") String sizeName, Pageable pageable);



}
