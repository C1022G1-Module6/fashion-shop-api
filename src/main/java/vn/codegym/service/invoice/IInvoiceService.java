package vn.codegym.service.invoice;

import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.entity.invoice.Invoice;

import java.util.List;

public interface IInvoiceService {
    void save(InvoiceDTO invoiceDTO);
    Invoice findLastInvoiceInList();
    InvoiceDTO getInvoiceDetail();
    String update (InvoiceDTO invoiceDTO);
    List<InvoiceDTO> findAll();
}
