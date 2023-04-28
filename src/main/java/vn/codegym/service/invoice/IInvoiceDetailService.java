package vn.codegym.service.invoice;

import vn.codegym.dto.invoice.InvoiceDetailDTO;

import java.util.List;



public interface IInvoiceDetailService {
    void save(InvoiceDetailDTO invoiceDetailDTO);
    void delete(Integer id);
    List<InvoiceDetailDTO> findAll();
    void deleteAll();
}

