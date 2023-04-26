package vn.codegym.entity.data_entry;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "data_entry")
public class DataEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // Hỏi Tân cách làm mã tự động tăng
    private String code;
    private Date date;
    @Column(name = "employee_name")
    private String employeeName;
    @OneToMany(mappedBy = "dataEntry")
    private Set<DataEntryProduct> dataEntryProductSet;

    public DataEntry() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Set<DataEntryProduct> getDataEntryProductSet() {
        return dataEntryProductSet;
    }

    public void setDataEntryProductSet(Set<DataEntryProduct> dataEntryProducts) {
        this.dataEntryProductSet = dataEntryProducts;
    }
}
