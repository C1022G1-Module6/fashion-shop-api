package vn.codegym.dto.data_entry;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Set;

public class DataEntryDTO {
    private Integer id;
    @Pattern(regexp = "^MH\\d{6}$", message = "Nhập đúng định dạng mã MHXXXXXX với X là số từ 0-9")
    private String code;

    private String date;
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
}
