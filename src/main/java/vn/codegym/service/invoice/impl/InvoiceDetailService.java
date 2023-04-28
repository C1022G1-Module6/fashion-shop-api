package vn.codegym.service.invoice.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.dto.invoice.InvoiceDetailDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.entity.invoice.InvoiceDetail;
import vn.codegym.repository.invoice.IInvoiceDetailRepository;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.service.invoice.IInvoiceDetailService;
import org.springframework.stereotype.Service;
import vn.codegym.service.invoice.IInvoiceService;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceDetailService implements IInvoiceDetailService {

}