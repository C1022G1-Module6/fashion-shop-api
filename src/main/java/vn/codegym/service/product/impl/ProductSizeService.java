package vn.codegym.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.repository.product.IProductSizeRepository;
import vn.codegym.service.product.IProductSizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSizeService implements IProductSizeService {

    @Autowired
    private IProductSizeRepository productSizeRepository;

    @Override
    public List<ProductSize> getAllProductSizes() {
        return productSizeRepository.findAll();
    }

    @Override
    public void addProductSize(String name) {
        productSizeRepository.addProductSize(name);
    }

    @Override
    public void save(ProductSize productSize) {
        productSizeRepository.save(productSize);
    }
}
