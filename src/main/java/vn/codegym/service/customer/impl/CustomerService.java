package vn.codegym.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.entity.customer.Customer;
import vn.codegym.repository.customer.ICustomerRepository;
import vn.codegym.service.customer.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: add new customer
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
     */
    @Override
    public void saveCustomer(String code, String name, boolean gender, String dateOfBirth, String address, String email, String phoneNumber, Integer point, Integer customerTypeId) {
        iCustomerRepository.saveCustomer(code, name, gender, dateOfBirth, address, email, phoneNumber, point, customerTypeId);
    }


    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: find customer by id
     *
     * @param id
     * @return
     */
    @Override
    public Customer findCustomerById(Integer id) {
        return iCustomerRepository.findCustomerById(id);
    }


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
    @Override
    public void updateCustomer(String code, String name, boolean gender, String dateOfBirth, String address, String email, String phoneNumber, Integer point, Integer customerTypeId, Integer id) {
        iCustomerRepository.updateCustomer(code, name, gender, dateOfBirth, address, email, phoneNumber, point, customerTypeId, id);
    }

    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: check exist add  Customer
     *
     * @param customerDTO
     * @return
     */
    @Override
    public Map<String, String> checkCreate(CustomerDTO customerDTO) {
        Map<String,String> checkCustomer = new HashMap<>();
        for (int i = 0; i < iCustomerRepository.findAllCustomer().size(); i++) {
            if (iCustomerRepository.findAllCustomer().get(i).getCode().equals(customerDTO.getCode())) {
                checkCustomer.put("errorCode", "Mã khách hàng đã tồn tại!");
            }
            if (iCustomerRepository.findAllCustomer().get(i).getPhoneNumber().equals(customerDTO.getPhoneNumber())) {
                checkCustomer.put("errorPhone", "Số điện thoại đã tồn tại trong hệ thống.");
            }
            if (iCustomerRepository.findAllCustomer().get(i).getEmail().equals(customerDTO.getEmail())) {
                checkCustomer.put("errorEmail", "Email đã tồn tại trong hệ thống.");
            }
        }
        return checkCustomer;
    }

    /**
     * Created by: TienTHM
     * Date created: 24/04/2022
     * function: check exist update Customer
     *
     * @param customerDTO
     * @return
     */
    @Override
    public Map<String, String> checkUpdate(CustomerDTO customerDTO) {
        Map<String, String> checkCustomer = new HashMap<>();
        Customer customer = findCustomerById(customerDTO.getId());
        for (int i = 0; i < iCustomerRepository.findAllCustomer().size(); i++) {
            if (!customer.getCode().equals(customerDTO.getCode()) && iCustomerRepository.findAllCustomer().get(i).getCode().equals(customerDTO.getCode())) {
                checkCustomer.put("errorCode", "Mã khách hàng đã tồn tại trong hệ thống.");
            }
            if (!customer.getPhoneNumber().equals(customer.getPhoneNumber()) && iCustomerRepository.findAllCustomer().get(i).getPhoneNumber().equals(customerDTO.getPhoneNumber())) {
                checkCustomer.put("errorPhone", "Số điện thoại đã tồn tại trong hệ thống.");
            }
            if (!customer.getEmail().equals(customerDTO.getEmail()) && iCustomerRepository.findAllCustomer().get(i).getEmail().equals(customerDTO.getEmail())) {

                checkCustomer.put("errorEmail", "Email đã tồn tại trong hệ thống.");
            }
        }
        return null;
    }
}
