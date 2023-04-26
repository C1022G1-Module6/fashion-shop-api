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


    /**
     * Create by: TanTH
     * Date create: 24/04/2023
     * Function:  connect service to get data corresponding
     *
     * @return
     */

    @Override
    public List<ProductType> ListProductType() {
        return productTypeRepository.ListProductType();

    }
}
