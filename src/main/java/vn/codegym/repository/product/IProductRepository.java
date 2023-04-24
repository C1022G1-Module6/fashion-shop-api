package vn.codegym.repository.product;

import vn.codegym.entity.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where code like concat('%', :code, '%') " +
            "and qrimg like concat('%', :qrImg, '%')", nativeQuery = true)
    List<Product> findProductWithCode(Pageable pageable,
                                      @Param("code") String code,
                                      @Param("qrImg") String qrImg);
    @Query(value = "select * from product where id = :id", nativeQuery = true)
    Product findWithId(@Param("id") Integer id);
}
