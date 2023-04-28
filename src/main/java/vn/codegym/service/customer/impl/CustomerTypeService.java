package vn.codegym.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.entity.customer.CustomerType;
import vn.codegym.repository.customer.ICustomerTypeRepository;
import vn.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.entity.customer.CustomerType;
import vn.codegym.repository.customer.ICustomerTypeRepository;
import vn.codegym.service.customer.ICustomerTypeService;

import java.util.List;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    /**
     * Function to retrieve all types of customers
     * @return a list of CustomerType objects
     */
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAllCustomerType();
    }
}
