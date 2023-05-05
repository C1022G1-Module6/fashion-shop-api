package vn.codegym.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.entity.product.Product;
import vn.codegym.dto.product.ProductCreateDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.dto.product.ProductDetailDTO;
import vn.codegym.service.product.IProductService;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("*")
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

    /**
     * created by : QuanTVA
     *
     * @param "pageable"
     * @return : Page<Product>
     * function : findAllProduct
     */
    @GetMapping("/stock")
    public ResponseEntity<Page<ProductDTO>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDTO> products = productService.findAllProducts(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Created by : QuanTVA
     *
     * @param id
     * @return : List<ProductDetailDTO>
     * Function : findAllByIdProduct
     */
    @GetMapping("/detail")
    public ResponseEntity<List<ProductDetailDTO>> getProductDetails(@RequestParam(required = false) Integer id) {
        List<ProductDetailDTO> productDetailDTOList = productService.findAllByProductId(id);
        if (productDetailDTOList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDetailDTOList, HttpStatus.OK);
    }

    /**
     * created by : QuanTVA
     *
     * @param productName
     * @param "productSizeList"
//     * @param productTypeId
     * @param "pageable"
     * @return Page<ProductDTO>
     * Function : search
     */
    @GetMapping("/search")
    public ResponseEntity<?> searchProducts(
            @RequestParam(required = false, defaultValue = "") String productName,
            @RequestParam(required = false, defaultValue = "") String code,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        if (productName.matches("[^a-zA-Z0-9]+")) {
            return new ResponseEntity<>("Không được nhập ký tự đặc biệt",HttpStatus.BAD_REQUEST);
        }

        Page<ProductDTO> products = productService.searchProducts(productName, code, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/search-type")
    public ResponseEntity<Page<ProductDTO>> searchProductsWithType(
            @RequestParam(required = false ,defaultValue = "") String productTypeId,
            @PageableDefault(size = 10)Pageable pageable
    ) {

        Page<ProductDTO> products = productService.findWithProductType(productTypeId, pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * created by QuanTVA
     *
     * @param productCreateDTO
     * @return ResponseEntity<>(HttpStatus.CREATED)
     * @throws IOException
     */
    @PostMapping("/create-product")
    public ResponseEntity<?> createProduct(@Validated @RequestBody ProductCreateDTO productCreateDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            productService.addProduct(productCreateDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
