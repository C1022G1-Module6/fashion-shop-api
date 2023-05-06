package vn.codegym.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.product.ProductSizeDetailDTO;
import vn.codegym.service.product.IProductSizeDetailService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product-size-detail")
public class ProductSizeDetailRestController {
    @Autowired
    private IProductSizeDetailService productSizeDetailService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductSizeDetailDTO> findAll() {
        return productSizeDetailService.findAll();
    }
}
