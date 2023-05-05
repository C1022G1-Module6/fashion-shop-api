package vn.codegym.service.invoice;

import vn.codegym.dto.invoice.InvoiceDetailDTO;

import java.util.List;

public interface IInvoiceDetailService {
    String save(InvoiceDetailDTO invoiceDetailDTO);
    void delete(Integer id);
    List<InvoiceDetailDTO> findAll();
}

