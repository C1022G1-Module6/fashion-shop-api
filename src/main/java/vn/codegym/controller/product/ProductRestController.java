package vn.codegym.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.entity.product.ProductType;
import vn.codegym.service.product.IProductService;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDTO> products = productService.findAllProducts(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProductDTO>> searchProducts(
            @RequestParam(defaultValue = "") String productName,
            @RequestParam(required = false) Integer productTypeId,
            @RequestParam(required = false) String[] productSizes,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDTO> products = productService.searchProducts(productName, productTypeId, productSizes, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestParam("productCode") String productCode,
                                           @RequestParam("productName") String productName,
                                           @RequestParam("productEntryPrice") Double productEntryPrice,
                                           @RequestParam("productTypeId") Integer productTypeId,
                                           @RequestParam(value = "productImg", required = false) MultipartFile productImg,
                                           @RequestParam(value = "productQrImg", required = false) String productQrImg,
                                           @RequestParam(value = "productSizes", required = false) Set<ProductSize> productSizes) throws IOException {

        productService.addProduct(productCode, productName, productEntryPrice, ProductType.valueOf(productTypeId), productImg, productQrImg, productSizes);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
