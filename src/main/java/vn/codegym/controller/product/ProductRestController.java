package vn.codegym.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vn.codegym.dto.product.ProductCreateDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.dto.product.ProductDetailDTO;
import vn.codegym.entity.product.Product;
import vn.codegym.service.product.IProductService;

import java.io.IOException;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private IProductService productService;
    /**
     * created by : QuanTVA
     * @param "pageable"
     * @return : Page<Product>
     *     function : findAllProduct
     */
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.findAllProducts(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    /**
     * Created by : QuanTVA
     * @param id
     * @return : List<ProductDetailDTO>
     *  Function : findAllByIdProduct
     */
    @GetMapping("/detail")
    public ResponseEntity<List<ProductDetailDTO>> productDetails(@RequestParam(required = false) Integer  id){
        List<ProductDetailDTO> productDetailDTOList = productService.findAllByProductId(id);
        if (productDetailDTOList.size() == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productDetailDTOList,HttpStatus.OK);
    }
    /**
     *created by : QuanTVA
     * @param productName
     * @param "productSizeList"
     * @param productTypeId
     * @param "pageable"
     * @return Page<ProductDTO>
     *     Function : search
     */
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

    /**
     * created by QuanTVA
     * @param productCreateDTO
     * @return ResponseEntity<>(HttpStatus.CREATED)
     * @throws IOException
     */
    @PostMapping("/create-product")
    public ResponseEntity<ProductCreateDTO> createProduct(@RequestBody ProductCreateDTO productCreateDTO) throws IOException {

        productService.addProduct(productCreateDTO);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
