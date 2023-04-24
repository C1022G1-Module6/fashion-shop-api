package vn.codegym.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import vn.codegym.dto.product.ProductDTO;
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

    public Page<ProductDTO> findAllProducts(Pageable pageable) {
        return productRepository.findAllProducts(pageable);
    }

    public Page<ProductDTO> searchProducts(String productName, Integer productTypeId, String[] productSizes, Pageable pageable) {
        List<String> productSizeList = null;
        if (productSizes != null) {
            productSizeList = new ArrayList<>();
            Collections.addAll(productSizeList, productSizes);
        }
        return productRepository.search(productName, productSizeList, productTypeId, pageable);
    }

    public void addProduct(String productCode, String productName, Double productEntryPrice, ProductType productType, MultipartFile productImg, String productQrImg, Set<ProductSize> productSizes) throws IOException {
        // Save product
        Product product = new Product();
        product.setCode(productCode);
        product.setName(productName);
        product.setEntryPrice(productEntryPrice);
        product.setProductType(productType);
        product.setDelete(false);
        product = productRepository.save(product);

        // Save product image
        String productImgName = StringUtils.cleanPath(productImg.getOriginalFilename());
        product.setImg(productImgName);
        String productImgPath = "src/main/resources/static/images/product/" + productImgName;
        File productImgFile = new File(productImgPath);
        productImgFile.getParentFile().mkdirs();
        productImg.transferTo(productImgFile);

        // Save product QR image
        product.setQrImg(productQrImg);

        // Save product size details
        for (ProductSize productSize : productSizes) {
            productSize.setProduct(product);
        }
        product.setProductSizes(productSizes);
        productRepository.save(product);
    }
}


