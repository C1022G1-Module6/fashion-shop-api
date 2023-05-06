package vn.codegym.service.product;

import vn.codegym.dto.product.ProductSizeDetailDTO;

import java.util.List;

public interface IProductSizeDetailService {
    List<ProductSizeDetailDTO> findAll();
}
