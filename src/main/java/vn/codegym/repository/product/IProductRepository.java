package vn.codegym.repository.product;

import org.springframework.data.domain.Page;
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

}
