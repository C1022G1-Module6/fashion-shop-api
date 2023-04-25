package vn.codegym.entity.data_entry;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import vn.codegym.entity.customer.Customer;
import vn.codegym.entity.product.Product;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "data_entry")
public class DataEntry {
    @Id
    @GeneratedValue(generator = "dataEntryCodeGenerator")
    @GenericGenerator(name = "dataEntryCodeGenerator", strategy = "vn.codegym.util.CustomInvoiceCodeGenerator")
    private String code;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String date;
    @Column(name = "employee_name")
    private String employeeName;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
    @OneToMany(mappedBy = "data_entry")
    @JsonManagedReference
    private Set<DataEntryProduct> dataEntryProductSet;
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
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

    public Set<DataEntryProduct> getDataEntryProductSet() {
        return dataEntryProductSet;
    }

    public void setDataEntryProductSet(Set<DataEntryProduct> dataEntryProductSet) {
        this.dataEntryProductSet = dataEntryProductSet;
    }

    public DataEntry() {
    }
}
