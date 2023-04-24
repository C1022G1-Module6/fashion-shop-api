package vn.codegym.service.customer;

import vn.codegym.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: find all customer type
     *
     * @return
     */
    List<CustomerType> getAllCustomerType();
}
