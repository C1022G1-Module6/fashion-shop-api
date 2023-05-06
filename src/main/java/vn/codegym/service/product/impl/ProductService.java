package vn.codegym.service.product.impl;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.product.*;
import vn.codegym.entity.product.Product;
import vn.codegym.entity.product.ProductSizeDetail;
import vn.codegym.entity.product.ProductType;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.repository.product.IProductSizeDetailRepository;
import vn.codegym.repository.product.IProductTypeRepository;
import vn.codegym.service.product.IProductService;
import org.springframework.stereotype.Service;
import java.util.*;
import static vn.codegym.qr.MyQr.createQR;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IProductTypeRepository productTypeRepository;
    @Autowired
    private IProductSizeDetailRepository iProductSizeDetailRepository;

    @Autowired
    private IProductSizeRepository productSizeRepository;


    public void setValueForProduct(Product product) {
        List<ProductSizeDetail> productSizeDetails = iProductSizeDetailRepository.findAll();
        Integer sum = 0;
        for (ProductSizeDetail productSizeDetail: productSizeDetails) {
            if (Objects.equals(productSizeDetail.getProduct().getId(), product.getId())) {
                sum += productSizeDetail.getQuantity();
            }
        }
        product.setQuantity(sum);
    }

    /**
     * Created by : QuanTVA
     * @param id
     * @return : List<ProductDetailDTO>
     * Function : findAllByIdProduct
     */
    @Override
    public List<ProductDetailDTO> findAllByProductId(int id) {
        return productRepository.findAllByIdProduct(id);
    }

    public void setValueForProduct(Product product) {
        List<ProductSizeDetail> productSizeDetails = iProductSizeDetailRepository.findAll();
        Integer sum = 0;
        for (ProductSizeDetail productSizeDetail: productSizeDetails) {
            if (Objects.equals(productSizeDetail.getProduct().getId(), product.getId())) {
                sum += productSizeDetail.getQuantity();
            }
        }
        product.setQuantity(sum);
    }

    /**
     * created by : QuanTVA
     *
     * @param pageable
     * @return : Page<Product>
     * function : findAllProduct
     */
    public Page<ProductDTO> findAllProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAllProducts(pageable);
        List<ProductDTO> productDTOS = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product: products) {
            productDTO = new ProductDTO();
            productDTO.setProductType(new ProductTypeDTO());
            BeanUtils.copyProperties(product.getProductType(), productDTO.getProductType());
            BeanUtils.copyProperties(product, productDTO);
            productDTOS.add(productDTO);
        }
        return new PageImpl<>(productDTOS, pageable, products.getTotalElements());
    }

    /**
     * created by : QuanTVA
     *
     * @param productName
     * @param "productSizeList"
     * @param pageable
     * @return Page<ProductDTO>
     * Function : search
     */
    public Page<ProductDTO> searchProducts(String productName, String code, Pageable pageable) {
        Page<Product> products = productRepository.search(productName, code, pageable);
        List<ProductDTO> productDTOS = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product: products) {
            productDTO = new ProductDTO();
            productDTO.setProductType(new ProductTypeDTO());
            BeanUtils.copyProperties(product.getProductType(), productDTO.getProductType());
            BeanUtils.copyProperties(product, productDTO);
            productDTOS.add(productDTO);
        }
        return new PageImpl<>(productDTOS, pageable, products.getTotalElements());
    }

    /**
     * created by QuanTVA
     *
     * @param productCreateDTO function : addProduct
     */
    public void addProduct(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setQuantity(0);
        product.setProductType(new ProductType(productCreateDTO.getProductType().getId()));
        String imgPath = productCreateDTO.getImg();
        String newImgFilePath = imgPath.replace("C:\\fakepath\\", "img/");
        productCreateDTO.setImg(newImgFilePath);
        BeanUtils.copyProperties(productCreateDTO, product);
        int id = productRepository.getTotalCodeAmount() + 100000;
        product.setCode("MH" + id);
        String qrImgPath = "E:\\Codegym\\project_reactJS\\fashion-shop-reactjs\\src\\qrCode" + product.getCode() + ".png";
        try {
            Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            createQR(product.getCode(), qrImgPath, "UTF-8", hintMap, 200, 200);
            product.setQrImg(qrImgPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        productRepository.addProduct(
                product.getCode(),
                product.getName(),
                product.getImg(),
                product.getQrImg(),
                product.getEntryPrice(),
                product.getSellingPrice(),
                product.getProductType().getId(),
                product.isDelete(),
                product.getQuantity());

        Product product1 = productRepository.findWithCode(product.getCode());
        for (ProductSizeDTO size : productCreateDTO.getProductSizes()) {
            ProductSizeDetail productSizeDetail = new ProductSizeDetail();
            productSizeDetail.setQuantity(0);
            productSizeDetail.setProduct(product1);
            ProductSize productSize = productSizeRepository.findById(size.getId()).get();
            productSizeDetail.setCode(product.getCode()+ productSize.getName());
            productSizeDetail.setProductSize(productSize);
            iProductSizeDetailRepository.save(productSizeDetail);
        }
    }

    /**
     * created by QuanTVA
     *
     * @param id
     * @return Product
     */
    @Override
    public Product findWithId(Integer id) {
        return productRepository.findWithId(id);
    }

    @Override
    public Page<ProductDTO> findWithProductType(String productTypeId, Pageable pageable) {
        Page<Product> products = productRepository.searchWithType(productTypeId, pageable);
        List<ProductDTO> productDTOS = new ArrayList<>();
        ProductDTO productDTO;
        for (Product product: products) {
            productDTO = new ProductDTO();
            productDTO.setProductType(new ProductTypeDTO());
            BeanUtils.copyProperties(product.getProductType(), productDTO.getProductType());
            BeanUtils.copyProperties(product, productDTO);
            productDTOS.add(productDTO);
        }
        return new PageImpl<>(productDTOS, pageable, products.getTotalElements());
    }

    @Override

    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function:  connect repository to get data corresponding to the search data
     *
     * @param name
     * @param product_type_id
     * @return Returns a Page object containing a list of data corresponding to the data to be searched
     */

    public Page<Product> ListProduct(String name, Integer product_type_id, Pageable pageable) {
        return productRepository.ListProduct(name, product_type_id,pageable);
    }
}

