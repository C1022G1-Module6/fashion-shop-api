package vn.codegym.service.invoice;

import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.entity.invoice.Invoice;

public interface IInvoiceService {
    void save(InvoiceDTO invoiceDTO);
    Invoice findLastInvoiceInList();
    void update (InvoiceDTO invoiceDTO);
}
