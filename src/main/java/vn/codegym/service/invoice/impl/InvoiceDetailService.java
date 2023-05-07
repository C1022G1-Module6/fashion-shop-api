package vn.codegym.service.invoice.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.dto.invoice.InvoiceDetailDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.entity.invoice.InvoiceDetail;
import vn.codegym.entity.product.Product;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.entity.product.ProductSizeDetail;
import vn.codegym.repository.invoice.IInvoiceDetailRepository;
import vn.codegym.repository.invoice.IInvoiceRepository;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.repository.product.IProductSizeDetailRepository;
import vn.codegym.repository.product.IProductSizeRepository;
import vn.codegym.service.invoice.IInvoiceDetailService;
import org.springframework.stereotype.Service;
import vn.codegym.service.invoice.IInvoiceService;
import vn.codegym.service.product.impl.ProductService;

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
    @Autowired
    private IProductSizeDetailRepository productSizeDetailRepository;
    @Autowired
    private IProductSizeRepository productSizeRepository;
    @Autowired
    private ProductService productService;
    Integer count = 0;

    public void saveNewInvoice() {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        int id = invoiceRepository.getTotalCodeAmount() + 100000;
        invoiceDTO.setCode("HD" + id);
        invoiceDTO.setDate(LocalDate.now().toString());
        invoiceService.save(invoiceDTO);
    }

    /**
     * this method is applied to create new invoice with invoiceDetailDTO as param
     * when this method is request, it also increases count value and create new invoice instance to db
     * by using save method from invoiceService (only create if count = 0)
     *
     * @param invoiceDetailDTO
     */
    @Override
    public String save(InvoiceDetailDTO invoiceDetailDTO) {
        ProductSize productSize = productSizeRepository.findById(Integer.parseInt(invoiceDetailDTO.getSize())).get();
        Product product = productRepository.findWithCode(invoiceDetailDTO.getProductDTO().getCode());
        if (product == null) {
            return "Không có hàng này trong kho";
        }
        ProductSizeDetail productSizeDetail = productSizeDetailRepository.findWithProductSizeAndProduct(productSize.getId(), product.getId());
        if (productSizeDetail == null) {
            return "Không có size này trong kho";
        }
        if (invoiceDetailDTO.getQuantity() > productSizeDetail.getQuantity()) {
            return "Số lượng hàng trong kho không đủ";
        }
        if (count == 0) {
            saveNewInvoice();
        }
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        invoiceDetailDTO.setProductSizeCode(product.getCode() + productSize.getName());
        BeanUtils.copyProperties(invoiceDetailDTO, invoiceDetail);
        invoiceDetail.setInvoice(invoiceService.findLastInvoiceInList());
        invoiceDetail.setProduct(productSizeDetail.getProduct());
        invoiceDetail.setTotal(invoiceDetail.getProduct().getSellingPrice() * invoiceDetailDTO.getQuantity());
        if (productSizeDetail.getQuantity() - invoiceDetail.getQuantity() < 0) {
            return "Số lượng hàng trong kho không đủ";
        }
        productSizeDetail.setQuantity(productSizeDetail.getQuantity() - invoiceDetail.getQuantity());
        productSizeDetailRepository.save(productSizeDetail);
        productService.setValueForProduct(product);
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findAll();

        if (invoiceDetails.isEmpty()) {
            invoiceDetailRepository.save(invoiceDetail);
        }

        InvoiceDetail invoiceDetail1 = invoiceDetails.get(invoiceDetails.size() - 1);
        if (invoiceDetailDTO.getProductSizeCode().equals(invoiceDetail1.getProductSizeCode()) && count != 0) {
            invoiceDetail1.setQuantity(invoiceDetail1.getQuantity() + invoiceDetailDTO.getQuantity());
            invoiceDetail1.setTotal(invoiceDetail1.getQuantity() * invoiceDetail1.getProduct().getSellingPrice());
            invoiceDetailRepository.save(invoiceDetail1);
        } else {
            invoiceDetailRepository.saveInvoiceDetail(invoiceDetail.getQuantity(),
                    invoiceDetail.getTotal(),
                    invoiceDetail.getInvoice().getId(),
                    invoiceDetail.getProduct().getId(),
                    productSize.getName(),
                    invoiceDetail.getProductSizeCode(),
                    invoiceDetail.getDelete());
        }
        count++;
        return "";
    }

    public void resetCount() {
        count = 0;
    }

    /**
     * this methois applied to delete an invoiceDetail instance by set the isDelete value to true
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findDetailWithId(id);
        invoiceDetail.setDelete(true);
        invoiceDetailRepository.save(invoiceDetail);
    }

    /**
     * This function get all invoiceDetailDTO instances and return a list of invoice instances
     *
     * @return
     */

    @Override
    public List<InvoiceDetailDTO> findAll() {
        List<InvoiceDetail> invoiceDetailList = invoiceDetailRepository
                .getAllWithId(invoiceService.findLastInvoiceInList().getId());
        List<InvoiceDetailDTO> invoiceDetailDTOList = new ArrayList<>();
        InvoiceDetailDTO invoiceDetailDTO;
        for (InvoiceDetail invoiceDetail : invoiceDetailList) {
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