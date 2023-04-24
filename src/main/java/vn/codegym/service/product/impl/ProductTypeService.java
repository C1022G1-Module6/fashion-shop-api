package vn.codegym.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.entity.product.ProductType;
import vn.codegym.repository.product.IProductTypeRepository;
import vn.codegym.service.product.IProductTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {

    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }
}
