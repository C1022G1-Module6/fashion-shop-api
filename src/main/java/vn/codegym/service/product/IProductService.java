package vn.codegym.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.product.ProductCreateDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.dto.product.ProductDetailDTO;
import vn.codegym.entity.product.Product;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.entity.product.ProductType;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface IProductService {

    List<ProductDetailDTO> findAllByProductId(int id);
    Page<ProductDTO> findAllProducts(Pageable pageable);
    Page<ProductDTO> searchProducts(String productName, String productTypeId, Pageable pageable);
    void addProduct(ProductCreateDTO productCreateDTO);

    Product findWithId(Integer id);
    Page<ProductDTO> findWithProductType(String productTypeId, Pageable pageable);

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
