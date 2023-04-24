package vn.codegym.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.entity.product.Product;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.service.product.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override

    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function:  connect repository to get data corresponding to the search data
     *
     * @param name
     * @param product_type_id
     * @return Returns a Page object containing a list of data corresponding to the data to be searched
     */

    public Page<Product> ListProduct(String name, Integer product_type_id, Pageable pageable) {
        return productRepository.ListProduct(name, product_type_id,pageable);
    }

}
