package vn.codegym.dto.product;

import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class ProductCreateDTO {
    private String code;
    private String name;
    private Integer quantity;
    private String qrImg;
    private String img;
    private Double sellingPrice;
    private ProductTypeDTO productType;
    private Set<ProductSizeDTO> productSizes;
    private boolean isDelete = false;
    public ProductCreateDTO() {
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

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public Set<ProductSizeDTO> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(Set<ProductSizeDTO> productSizes) {
        this.productSizes = productSizes;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
