package vn.codegym.service.customer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.entity.customer.Customer;
import vn.codegym.repository.customer.ICustomerRepository;
import vn.codegym.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.dto.customer.CustomerTypeDTO;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    /**
     * Function search customer
     * @param pageable
     * @param searchCode
     * @param searchName
     * @param searchPhoneNumber
     * @return method returns a page of customer data in CustomerDTO format,
     * including the list of customers found, pagination (paginable) information,
     * and the total number of customers found.
     */
    @Override
    public Page<CustomerDTO> searchCustomer(Pageable pageable, String searchCode, String searchName, String searchPhoneNumber) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        Page<Customer> customerPage = customerRepository
              .searchCustomerInfo(pageable, searchCode, searchName, searchPhoneNumber);
        CustomerDTO customerDTO;
        for (Customer customer : customerPage) {
            customerDTO = new CustomerDTO();
            customerDTO.setCustomerTypeDTO(new CustomerTypeDTO());
            BeanUtils.copyProperties(customer.getCustomerType(), customerDTO.getCustomerTypeDTO());
            BeanUtils.copyProperties(customer, customerDTO);
            customerDTOList.add(customerDTO);
        }
        return new PageImpl<>(customerDTOList, pageable, customerPage.getTotalElements());
    }

    /**
     * Function delete customer
     * @param id
     */
    @Override
    public void deleteCustomer(int id) {
        Customer customer = customerRepository.findByCustomerId(id);
        customer.setDelete(true);
        customerRepository.save(customer);
    }
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
     */
    @Override
    public void saveCustomer(String code, String name, boolean gender, String dateOfBirth, String address,
                             String email, String phoneNumber, Integer point,Integer customerId) {
        int id = customerRepository.getTotalCodeAmount();
        String newCode = "KH-" + 0 + id;
        customerRepository.saveCustomer(newCode, name, gender, dateOfBirth, address, email, phoneNumber, point,customerId);
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
    public Customer findByCustomerId(Integer id) {
        return customerRepository.findByCustomerId(id);
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
        customerRepository.updateCustomer(code, name, gender, dateOfBirth, address, email, phoneNumber, point, customerTypeId, id);
    }

}
