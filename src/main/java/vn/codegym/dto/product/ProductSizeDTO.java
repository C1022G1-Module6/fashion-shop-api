package vn.codegym.dto.product;

import java.util.Set;

public class ProductSizeDTO {
    private Integer id;
    private String name;
    private Set<ProductSizeDetailDTO> productSizeDetailDTOS;
    public ProductSizeDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductSizeDetailDTO> getProductSizeDetailDTOS() {
        return productSizeDetailDTOS;
    }

    public void setProductSizeDetailDTOS(Set<ProductSizeDetailDTO> productSizeDetailDTOS) {
        this.productSizeDetailDTOS = productSizeDetailDTOS;
    }
}
