package vn.codegym.repository.product;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.Query;

import vn.codegym.entity.product.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {


    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function:  connect service to get data corresponding
     *
     * @return
     */

    @Query(value = "select * from product_type", nativeQuery = true)
    List<ProductType> ListProductType();

}
