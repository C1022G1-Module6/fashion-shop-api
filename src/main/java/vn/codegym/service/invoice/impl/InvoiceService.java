package vn.codegym.service.invoice.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.entity.invoice.Invoice;
import vn.codegym.projection.statistical.INumberOfCustomerProjection;
import vn.codegym.repository.invoice.IInvoiceRepository;
import vn.codegym.service.invoice.IInvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository invoiceRepository;

    @Override
    public void save(InvoiceDTO invoiceDTO) {
        Invoice invoice = new Invoice();
        if (invoiceDTO.getCustomerDTO() == null && invoiceDTO.getInvoiceDetailDTOS() == null) {
            invoiceRepository.save(invoice);
        } else {
            BeanUtils.copyProperties(invoiceDTO.getCustomerDTO(), invoice.getCustomer());
            BeanUtils.copyProperties(invoiceDTO.getInvoiceDetailDTOS(), invoice.getInvoiceDetails());
            BeanUtils.copyProperties(invoiceDTO, invoice);
            invoiceRepository.saveInvoice(invoice.getBonusPoint(),
                    invoice.getCode(),
                    invoice.getDate(),
                    invoice.getEmployeeName(),
                    invoice.getPayment(),
                    invoice.getTotal(),
                    invoice.getCustomer().getId());
        }
    }

    @Override
    public Invoice findLastInvoiceInList() {
        List<Invoice> invoiceList = invoiceRepository.listAllInvoice();
        Invoice invoice = invoiceList.get(invoiceList.size() - 1);
        return invoice;
    }

    @Override
    public void update(InvoiceDTO invoiceDTO) {
        Invoice invoice = findLastInvoiceInList();
        BeanUtils.copyProperties(invoiceDTO.getCustomerDTO(), invoice.getCustomer());
        BeanUtils.copyProperties(invoiceDTO.getInvoiceDetailDTOS(), invoice.getInvoiceDetails());
        BeanUtils.copyProperties(invoiceDTO, invoice);
        invoiceRepository.updateInvoice(invoice.getBonusPoint(),
                invoice.getCode(),
                invoice.getDate(),
                invoice.getEmployeeName(),
                invoice.getPayment(),
                invoice.getTotal(),
                invoice.getCustomer().getId(),
                invoice.getId());
    }

    @Override
    public List<INumberOfCustomerProjection> findAllCustomer() {
        return null;
    }

    @Override
    public Double getTotalRevenue(String startDate, String endDate) {
        return invoiceRepository.getTotalRevenue(startDate,endDate);
    }

//    @Override
//    public List<INumberOfCustomerProjection> findAllCustomer() {
//        return invoiceRepository.findNumberOfCustomer();
//    }


}
