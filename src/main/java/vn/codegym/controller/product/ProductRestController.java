package vn.codegym.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.entity.product.Product;
import vn.codegym.service.product.IProductService;

@RestController
@CrossOrigin
@RequestMapping("api/user/product")
public class ProductRestController {

    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function: connect service to get data corresponding to the search data
     *
     * @param name
     * @param product_type_id
     * @return
     */

    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public ResponseEntity<Page<Product>> listProducts(
            @RequestParam(name = "name", defaultValue = "") String name,
            @RequestParam(name = "product_type_id", defaultValue = "0") Integer product_type_id,
            @PageableDefault(size = 5) Pageable pageable) {
        Page<Product> products = productService.ListProduct(name, product_type_id, pageable);
        if (products.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(products);
    }

}