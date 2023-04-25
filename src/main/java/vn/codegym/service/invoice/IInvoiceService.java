package vn.codegym.service.invoice;

import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.entity.invoice.Invoice;
import vn.codegym.projection.statistical.INumberOfCustomerProjection;

import java.util.List;

public interface IInvoiceService {
    void save(InvoiceDTO invoiceDTO);
    Invoice findLastInvoiceInList();
    void update (InvoiceDTO invoiceDTO);

    List<INumberOfCustomerProjection>  findAllCustomer();

    Double getTotalRevenues(String startDate, String endDate);

}
