package vn.codegym.service.product.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import vn.codegym.dto.product.ProductCreateDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.dto.product.ProductDetailDTO;
import vn.codegym.dto.product.ProductSizeDTO;
import vn.codegym.entity.product.Product;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.entity.product.ProductType;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.service.product.IProductService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    /**
     * Created by : QuanTVA
     *
     * @param id
     * @return : List<ProductDetailDTO>
     * Function : findAllByIdProduct
     */
    @Override
    public List<ProductDetailDTO> findAllByProductId(int id) {
        return productRepository.findAllByIdProduct(id);
    }

    /**
     * created by : QuanTVA
     *
     * @param pageable
     * @return : Page<Product>
     * function : findAllProduct
     */
    public Page<Product> findAllProducts(Pageable pageable) {
        return productRepository.findAllProducts(pageable);
    }

    /**
     * created by : QuanTVA
     *
     * @param productName
     * @param "productSizeList"
     * @param productTypeId
     * @param pageable
     * @return Page<ProductDTO>
     * Function : search
     */
    public Page<ProductDTO> searchProducts(String productName, Integer productTypeId, String[] productSizes, Pageable pageable) {
        List<String> productSizeList = null;
        if (productSizes != null) {
            productSizeList = new ArrayList<>();
            Collections.addAll(productSizeList, productSizes);
        }
        return productRepository.search(productName, productSizeList, productTypeId, pageable);
    }

    /**
     * created by QuanTVA
     * @param productCreateDTO
     * function : addProduct
     */
    public void addProduct(ProductCreateDTO productCreateDTO){
        // Save product
        Product product = new Product();
        product.setProductType(new ProductType(productCreateDTO.getProductType().getId()));
        BeanUtils.copyProperties(productCreateDTO,product);
        productRepository.addProduct(product.getCode(),
                product.getName(),
                product.getImg(),
                product.getQrImg(),
                product.getEntryPrice(),
                product.getSellingPrice(),
                product.getProductType().getId(),
                product.isDelete());

        Product product1 = productRepository.findWithCode(product.getCode());

        for (ProductSizeDTO size:productCreateDTO.getProductSizes()) {
            productRepository.addProductSizeDetail(size.getId(), product1.getId());
        }


}

    /**
     *
     * created by QuanTVA
     * @param id
     * @return Product
     */
    @Override
    public Product findWithId(Integer id) {
        return productRepository.findWithId(id);
    }
}


