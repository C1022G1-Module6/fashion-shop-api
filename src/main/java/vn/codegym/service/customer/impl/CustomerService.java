package vn.codegym.service.customer.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.dto.customer.CustomerTypeDTO;
import vn.codegym.entity.customer.Customer;
import vn.codegym.repository.customer.ICustomerRepository;
import vn.codegym.service.customer.ICustomerService;

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
}
