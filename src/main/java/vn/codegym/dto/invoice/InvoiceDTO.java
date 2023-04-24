package vn.codegym.dto.invoice;

import vn.codegym.dto.customer.CustomerDTO;

import java.util.Set;

public class InvoiceDTO {
    private Integer id;
    private String code;
    private String date;
    private String employeeName;
    private Double total;
    private Double payment;
    private Integer bonusPoint;
    private CustomerDTO customerDTO;
    private Set<InvoiceDetailDTO> invoiceDetailDTOS;

    public InvoiceDTO() {
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

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public Set<InvoiceDetailDTO> getInvoiceDetailDTOS() {
        return invoiceDetailDTOS;
    }

    public void setInvoiceDetailDTOS(Set<InvoiceDetailDTO> invoiceDetailDTOS) {
        this.invoiceDetailDTOS = invoiceDetailDTOS;
    }
}
