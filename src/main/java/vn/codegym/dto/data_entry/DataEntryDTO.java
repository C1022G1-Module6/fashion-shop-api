package vn.codegym.dto.data_entry;

import vn.codegym.dto.product.ProductDTO;

import javax.persistence.Column;
import java.util.Set;

public class DataEntryDTO {
    private Integer id;
    private String code;
    private String date;
    private String employeeName;
    private ProductDTO productDTO;
    private Set<DataEntryProductDTO> dataEntryProductDTOSet;

    public ProductDTO getProductDTO() {
        return productDTO;
    }
    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Set<DataEntryProductDTO> getDataEntryProductDTOSet() {
        return dataEntryProductDTOSet;
    }

    public void setDataEntryProductDTOSet(Set<DataEntryProductDTO> dataEntryProductDTOSet) {
        this.dataEntryProductDTOSet = dataEntryProductDTOSet;
    }
    public DataEntryDTO() {
    }
}
