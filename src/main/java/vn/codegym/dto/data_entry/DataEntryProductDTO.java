package vn.codegym.dto.data_entry;

import vn.codegym.dto.product.ProductDTO;

public class DataEntryProductDTO {
    private Integer id;

    private Integer quantity;

    private DataEntryDTO dataEntryDTO;

    private ProductDTO productDTO;

    private Boolean isDelete = false;

    public DataEntryProductDTO() {
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
