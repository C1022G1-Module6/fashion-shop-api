package vn.codegym.service.product.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.dto.product.ProductSizeDTO;
import vn.codegym.dto.product.ProductSizeDetailDTO;
import vn.codegym.entity.product.ProductSizeDetail;
import vn.codegym.repository.product.IProductSizeDetailRepository;
import vn.codegym.service.product.IProductSizeDetailService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductSizeDetailService implements IProductSizeDetailService {
    @Autowired
    private IProductSizeDetailRepository productSizeDetailRepository;
    @Override
    public List<ProductSizeDetailDTO> findAll() {
        List<ProductSizeDetail> productSizeDetails = productSizeDetailRepository.findAll();
        List<ProductSizeDetailDTO> productSizeDetailDTOS = new ArrayList<>();
        ProductSizeDetailDTO productSizeDetailDTO;
        for (ProductSizeDetail productSizeDetail: productSizeDetails) {
            productSizeDetailDTO = new ProductSizeDetailDTO();
            productSizeDetailDTO.setProductDTO(new ProductDTO());
            productSizeDetailDTO.setProductSizeDTO(new ProductSizeDTO());
            BeanUtils.copyProperties(productSizeDetail.getProductSize(), productSizeDetailDTO.getProductSizeDTO());
            BeanUtils.copyProperties(productSizeDetail.getProduct(), productSizeDetailDTO.getProductDTO());
            BeanUtils.copyProperties(productSizeDetail, productSizeDetailDTO);
            productSizeDetailDTOS.add(productSizeDetailDTO);
        }
        return productSizeDetailDTOS;
    }
}
