package vn.codegym.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.entity.product.Product;

public interface IProductService {
    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function:  connect repository to get data corresponding to the search data
     *
     * @param name
     * @param product_type_id
     * @return
     */

    Page<Product> ListProduct(String name, Integer product_type_id, Pageable pageable);
}
