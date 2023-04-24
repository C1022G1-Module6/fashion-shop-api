package vn.codegym.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.entity.customer.CustomerType;
import vn.codegym.repository.customer.ICustomerTypeRepository;
import vn.codegym.service.customer.ICustomerTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    /**
     * Created by: TienTHM
     * Date created: 24/04/2023
     * Function: find all customer type
     *
     * @return
     */
    @Override
    public List<CustomerType> getAllCustomerType() {
        return iCustomerTypeRepository.getAllCustomerType();
    }
}
