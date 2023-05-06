package vn.codegym.dto.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class ProductDTO {
    private Integer id;
    private String code;
    private String name;
    private Integer quantity;
    private String qrImg;
    private String img;
    private Double sellingPrice;
    private Double entryPrice;
    private ProductTypeDTO productType;
    private Set<ProductSizeDetailDTO> productSizeDetailDTOS;




    public ProductDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getQrImg() {
        return qrImg;
    }

    public void setQrImg(String qrImg) {
        this.qrImg = qrImg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(Double entryPrice) {
        this.entryPrice = entryPrice;
    }

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public Set<ProductSizeDetailDTO> getProductSizeDetailDTOS() {
        return productSizeDetailDTOS;
    }

    public void setProductSizeDetailDTOS(Set<ProductSizeDetailDTO> productSizeDetailDTOS) {
        this.productSizeDetailDTOS = productSizeDetailDTOS;
    }
}
