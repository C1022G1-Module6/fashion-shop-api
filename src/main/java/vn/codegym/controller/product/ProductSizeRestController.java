package vn.codegym.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.entity.product.Product;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.service.product.IProductService;
import vn.codegym.service.product.IProductSizeService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductSizeRestController {
@Autowired
    private IProductSizeService iProductSizeService;
@Autowired
private IProductService productService;
@GetMapping("/product-size")
    public ResponseEntity<List<ProductSize>> findAllProductSize(){
    List<ProductSize> productSizes = iProductSizeService.getAllProductSizes();
    if (productSizes.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(productSizes, HttpStatus.OK);
}


}
