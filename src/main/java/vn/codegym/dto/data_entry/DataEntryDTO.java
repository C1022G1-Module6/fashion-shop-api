package vn.codegym.dto.data_entry;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class DataEntryDTO {
    @NotBlank(message = "không được để trống")
    private Integer id;
    @Pattern(regexp = "^MP\\d{6}$", message = "Mã phiếu có định dạng HDXXXXXX (X là số)")
    private String code;
    @NotBlank(message = "không được để trống")
    private String date;
    @NotBlank(message = "không được để trống")
    private String employeeName;
    private Set<DataEntryProductDTO> dataEntryProductDTOSet;

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
