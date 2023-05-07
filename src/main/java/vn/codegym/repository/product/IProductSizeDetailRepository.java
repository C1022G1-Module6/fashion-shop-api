package vn.codegym.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.entity.product.ProductSizeDetail;

public interface IProductSizeDetailRepository extends JpaRepository<ProductSizeDetail, Integer> {
    @Query(value = "select * from product_size_detail where product_id = :productId and product_size_id = :productSizeId", nativeQuery = true)
    ProductSizeDetail findWithProductSizeAndProduct(@Param("productSizeId") Integer productSizeId
            , @Param("productId") Integer productId);
    ProductSizeDetail findByCodeContaining(String code);
    ProductSizeDetail findByProductSize(ProductSize productSize);

}
