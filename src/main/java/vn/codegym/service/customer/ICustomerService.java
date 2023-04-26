package vn.codegym.service.customer;

import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.entity.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
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

//    void saveCustomer(String code,boolean gender);

    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: find customer by id
     * @param id
     */

    Customer findCustomerById(Integer id);


    List<Customer> findAllCustomer();

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



    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: check exist add  Customer
     * @param customerDTO
     * @return
     */

//    Map<String, String> checkCreate(CustomerDTO customerDTO);



    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: check exist update Customer
     *
     * @param customerDTO
     * @return
     */

//    Map<String, String> checkUpdate(CustomerDTO customerDTO);

}
