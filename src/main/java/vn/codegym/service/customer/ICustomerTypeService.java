package vn.codegym.service.customer;

import vn.codegym.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    /**
     * Function to retrieve all types of customers
     * @return a list of CustomerType objects
     */
    List<CustomerType> findAll();
}
