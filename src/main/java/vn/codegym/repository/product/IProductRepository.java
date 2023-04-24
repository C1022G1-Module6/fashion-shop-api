package vn.codegym.repository.product;

import vn.codegym.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where code like concat('%', :code, '%')", nativeQuery = true)
    Page<Product> findProductWithCode(Pageable pageable, @Param("code") String code);
}
