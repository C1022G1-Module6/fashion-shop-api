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

}

