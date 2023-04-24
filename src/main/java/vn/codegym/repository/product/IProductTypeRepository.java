package vn.codegym.repository.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
    @Query(value = "SELECT * FROM product_type WHERE is_deleted = false", nativeQuery = true)
    Page<ProductType> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM product_type WHERE LOWER(type_name) LIKE LOWER(CONCAT('%', :typeName, '%')) AND is_deleted = false", nativeQuery = true)
    Page<ProductType> search(@Param("typeName") String typeName, Pageable pageable);

}
