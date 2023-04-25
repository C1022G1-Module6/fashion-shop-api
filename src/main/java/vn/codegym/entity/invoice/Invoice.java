package vn.codegym.entity.invoice;
import vn.codegym.entity.customer.Customer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import vn.codegym.entity.employee.Employee;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String date;
//    @Column(name = "employee_name")
//    private String employeeName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;
    private Double total;
    private Double payment;
    @Column(name = "bonus_point")
    private Integer bonusPoint;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;
    @OneToMany(mappedBy = "invoice")
    @JsonManagedReference
    private Set<InvoiceDetail> invoiceDetails;

    public Invoice() {
    }

    public Integer getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

//    public String getEmployeeName() {
//        return employeeName;
//    }
//
//    public void setEmployeeName(String employeeName) {
//        this.employeeName = employeeName;
//    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(Integer bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(Set<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }
}