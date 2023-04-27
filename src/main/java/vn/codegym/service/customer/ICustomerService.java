package vn.codegym.service.customer;

import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.entity.customer.Customer;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.customer.CustomerDTO;

public interface ICustomerService {
    /**
     * Function search customer
     * @param pageable
     * @param searchCode
     * @param searchName
     * @param searchPhoneNumber
     * @return method will return a customer list page
     */
    Page<CustomerDTO> searchCustomer(Pageable pageable, String searchCode, String searchName, String searchPhoneNumber);

    void deleteCustomer(int id);

    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: create customer
     * @param code
     * @param name
     * @param gender
     * @param dateOfBirth
     * @param address
     * @param email
     * @param phoneNumber
     * @param point
     */
    void saveCustomer(String code, String name, boolean gender, String dateOfBirth, String address, String email,
                      String phoneNumber, Integer point,Integer customerTypeId);


    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: find customer by id
     * @param id
     */

    Customer findByCustomerId(Integer id);
    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: update customer
     *
     * @param code
     * @param name
     * @param gender
     * @param dateOfBirth
     * @param address
     * @param email
     * @param phoneNumber
     * @param point
     * @param customerTypeId
     * @param id
     */

    void updateCustomer(String code, String name, boolean gender, String dateOfBirth, String address, String email,
                        String phoneNumber, Integer point,Integer customerTypeId,Integer id);



}
