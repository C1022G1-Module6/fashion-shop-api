package vn.codegym.service.invoice.impl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.dto.invoice.InvoiceDetailDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.entity.invoice.InvoiceDetail;
import vn.codegym.repository.invoice.IInvoiceDetailRepository;
import vn.codegym.repository.invoice.IInvoiceRepository;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.service.invoice.IInvoiceDetailService;
import org.springframework.stereotype.Service;
import vn.codegym.service.invoice.IInvoiceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceDetailService implements IInvoiceDetailService {
    @Autowired
    private IInvoiceDetailRepository invoiceDetailRepository;
    @Autowired
    private IInvoiceService invoiceService;
    @Autowired
    private IInvoiceRepository invoiceRepository;
    @Autowired
    private IProductRepository productRepository;
    Integer count = 0;

    /**
     * this method is applied to create new invoice with invoiceDetailDTO as param
     * when this method is request, it also increases count value and create new invoice instance to db
     * by using save method from invoiceService (only create if count = 0)
     * @param invoiceDetailDTO
     */
    @Override
    public void save(InvoiceDetailDTO invoiceDetailDTO) {
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        if (count == 0) {
            InvoiceDTO invoiceDTO = new InvoiceDTO();
            int id = invoiceRepository.getTotalCodeAmount() + 100000;
            invoiceDTO.setCode("HD" + id);
            invoiceDTO.setDate(LocalDate.now().toString());
            invoiceService.save(invoiceDTO);
        }
        invoiceDetail.setInvoice(invoiceService.findLastInvoiceInList());
        invoiceDetail.setProduct(productRepository.findWithCode(invoiceDetailDTO.getProductDTO().getCode()));
        BeanUtils.copyProperties(invoiceDetailDTO, invoiceDetail);
        invoiceDetailRepository.saveInvoiceDetail(invoiceDetail.getQuantity(),
                invoiceDetail.getTotal(),
                invoiceDetail.getInvoice().getId(),
                invoiceDetail.getProduct().getId(),
                invoiceDetail.getDelete());
        count++;
    }
    public void resetCount() {
        count = 0;
    }

    /**
     * this methois applied to delete an invoiceDetail instance by set the isDelete value to true
     * @param id
     */
    @Override
    public void delete(Integer id) {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findDetailWithId(id);
        invoiceDetail.setDelete(true);
    }

    /**
     * This function get all invoiceDetailDTO instances and return a list of invoice instances
     * @return
     */

    @Override
    public List<InvoiceDetailDTO> findAll() {
        List<InvoiceDetail> invoiceDetailList = invoiceDetailRepository.listAllInvoiceDetail();
        List<InvoiceDetailDTO> invoiceDetailDTOList = new ArrayList<>();
        InvoiceDetailDTO invoiceDetailDTO;
        for (InvoiceDetail invoiceDetail: invoiceDetailList) {
            invoiceDetailDTO = new InvoiceDetailDTO();
            invoiceDetailDTO.setInvoiceDTO(new InvoiceDTO());
            invoiceDetailDTO.setProductDTO(new ProductDTO());
            BeanUtils.copyProperties(invoiceDetail.getInvoice(), invoiceDetailDTO.getInvoiceDTO());
            BeanUtils.copyProperties(invoiceDetail.getProduct(), invoiceDetailDTO.getProductDTO());
            BeanUtils.copyProperties(invoiceDetail, invoiceDetailDTO);
            invoiceDetailDTOList.add(invoiceDetailDTO);
        }
        return invoiceDetailDTOList;
    }
}