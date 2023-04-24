package vn.codegym.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.service.customer.ICustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class    CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    /**
     * Function search customer
     * @param pageable
     * @param searchCode
     * @param searchName
     * @param searchPhoneNumber
     * @return method will return a customer list page
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<CustomerDTO> getCustomer(@PageableDefault(size = 3) Pageable pageable,
                                         @RequestParam(required = false, defaultValue = "") String searchCode,
                                         @RequestParam(required = false, defaultValue = "") String searchName,
                                         @RequestParam(required = false, defaultValue = "") String searchPhoneNumber) {
        Sort sort = Sort.by("id").descending();
        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return customerService.searchCustomer(sortedPageaBle, searchCode, searchName, searchPhoneNumber);
    }

    /**
     * Function delete customer
     * @param id
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("")
    public void deleteCustomer(@RequestParam(required = false) Integer id) {
        customerService.deleteCustomer(id);
    }
}
