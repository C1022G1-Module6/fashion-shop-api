package vn.codegym.dto.invoice;

import vn.codegym.dto.customer.CustomerDTO;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

public class InvoiceDTO {
    private Integer id;
    @Pattern(regexp = "^HD\\d{6}$", message = "Mã hóa đơn có định dạng HDXXXXXX (X là số)")
    private String code;
    private String date;
    private String employeeName;
    @PositiveOrZero(message = "Tổng tiền phải là số dương")
    private Double total;
    @PositiveOrZero(message = "Thành tiền phải là số dương")
    private Double payment;
    @Positive(message = "Điểm thưởng phải là số nguyên dương")
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
