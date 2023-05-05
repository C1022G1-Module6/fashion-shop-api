package vn.codegym.dto.invoice;

import vn.codegym.dto.product.ProductDTO;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class InvoiceDetailDTO {

    private Integer id;
    @Positive(message = "Số lượng là số nguyên dương")
    private Integer quantity;
    @PositiveOrZero(message = "Tổng tiền phải là số dương")
    private Double total;
    private Boolean isDelete = false;
    private ProductDTO productDTO;
    private InvoiceDTO invoiceDTO;

    public InvoiceDetailDTO() {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public InvoiceDTO getInvoiceDTO() {
        return invoiceDTO;
    }

    public void setInvoiceDTO(InvoiceDTO invoiceDTO) {
        this.invoiceDTO = invoiceDTO;
    }
}

