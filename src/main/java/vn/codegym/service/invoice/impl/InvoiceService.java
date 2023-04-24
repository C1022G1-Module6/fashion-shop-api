package vn.codegym.service.invoice.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.entity.invoice.Invoice;
import vn.codegym.repository.invoice.IInvoiceRepository;
import vn.codegym.service.invoice.IInvoiceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService implements IInvoiceService {
    @Autowired
    private IInvoiceRepository invoiceRepository;

    /**
     * this method is applied to add new invoice instance with invoiceDTO as a param
     * by calling method saveInvoice from repository
     * this method also check whether the param is null or not
     * if null only save new invoice instance with null values
     * @param invoiceDTO
     */
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

    /**
     * this method is applied to find the last created invoice instance
     * @return
     */
    @Override
    public Invoice findLastInvoiceInList() {
        List<Invoice> invoiceList = invoiceRepository.listAllInvoice();
        Invoice invoice = invoiceList.get(invoiceList.size() - 1);
        return invoice;
    }

    /**
     * this method is applied to update value of invoice with invoiceDTO as param
     * by using method updateInvoice from repository
     * @param invoiceDTO
     */
    @Override
    public void update(InvoiceDTO invoiceDTO) {
        Invoice invoice = findLastInvoiceInList();
        BeanUtils.copyProperties(invoiceDTO.getCustomerDTO(), invoice.getCustomer());
//        BeanUtils.copyProperties(invoiceDTO.getInvoiceDetailDTOS(), invoice.getInvoiceDetails());
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

    /**
     * This function get all InvoiceDTO and return a list of invoice instances
     * by transfer the values of list created by using method listAllInvoice from repository
     * @return
     */
    @Override
    public List<InvoiceDTO> findAll() {
        List<Invoice> invoiceList = invoiceRepository.listAllInvoice();
        List<InvoiceDTO> invoiceDTOList = new ArrayList<>();
        InvoiceDTO invoiceDTO;
        for (Invoice invoice: invoiceList) {
            invoiceDTO = new InvoiceDTO();
            invoiceDTO.setCustomerDTO(new CustomerDTO());
            BeanUtils.copyProperties(invoice.getCustomer(), invoiceDTO.getCustomerDTO());
            BeanUtils.copyProperties(invoice, invoiceDTO);
            invoiceDTOList.add(invoiceDTO);
        }
        return invoiceDTOList;
    }
}
