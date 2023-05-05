package vn.codegym.dto.product;

public class ProductSizeDetailDTO {
    private Integer id;
    private Integer quantity;
    private String code;
    private ProductDTO productDTO;
    private ProductSizeDTO productSizeDTO;

    public ProductSizeDetailDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public ProductSizeDTO getProductSizeDTO() {
        return productSizeDTO;
    }

    public void setProductSizeDTO(ProductSizeDTO productSizeDTO) {
        this.productSizeDTO = productSizeDTO;
    }
}
