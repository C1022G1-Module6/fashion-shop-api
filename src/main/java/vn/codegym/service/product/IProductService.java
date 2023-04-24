package vn.codegym.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
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
    Page<Product> findAllProducts(Pageable pageable);
    Page<ProductDTO> searchProducts(String productName, Integer productTypeId, String[] productSizes, Pageable pageable);
    void addProduct(String productCode, String productName, Double productEntryPrice, ProductType productType, MultipartFile productImg, String productQrImg, Set<ProductSize> productSizes) throws IOException;
}

