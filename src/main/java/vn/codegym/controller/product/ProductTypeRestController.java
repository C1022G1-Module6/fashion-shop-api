package vn.codegym.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.entity.product.ProductType;
import vn.codegym.service.product.IProductTypeService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductTypeRestController {
@Autowired
    private IProductTypeService iProductTypeService;

@GetMapping("/product-type")
public ResponseEntity<List<ProductType>> findAllProductType(){
    List<ProductType> productTypes = iProductTypeService.getAllProductTypes();
    if (productTypes.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(productTypes, HttpStatus.OK);
}
}
