package vn.codegym.dto.data_entry;

import vn.codegym.dto.product.ProductDTO;

import javax.validation.constraints.Positive;

public class DataEntryProductDTO {
    private Integer id;
    @Positive(message = "Số lượng là số nguyên dương")
    private Integer quantity;
    private DataEntryDTO dataEntryDTO;
    private ProductDTO productDTO;
    private Boolean isDelete = false;

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

    public DataEntryDTO getDataEntryDTO() {
        return dataEntryDTO;
    }

    public void setDataEntryDTO(DataEntryDTO dataEntryDTO) {
        this.dataEntryDTO = dataEntryDTO;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
