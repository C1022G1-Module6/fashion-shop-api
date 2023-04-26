package vn.codegym.service.customer;

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

}
