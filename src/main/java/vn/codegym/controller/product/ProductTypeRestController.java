package vn.codegym.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.entity.product.ProductType;
import vn.codegym.service.product.IProductTypeService;
import java.util.List;

@CrossOrigin
@RequestMapping("api/user/productType")
public class ProductTypeRestController {

    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function:  connect service to get data corresponding
     *
     * @return
     */

    @Autowired
    private IProductTypeService productTypeService;
    @GetMapping("")
    public ResponseEntity<List<ProductType>> getAllProductType() {
        List<ProductType> productTypes = productTypeService.ListProductType();
        if (productTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productTypes, HttpStatus.OK);
    }
}
