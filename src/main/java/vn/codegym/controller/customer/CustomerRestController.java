package vn.codegym.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.service.customer.ICustomerService;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerRestController {
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
    public ResponseEntity<Page<CustomerDTO>> search(@PageableDefault(size = 3) Pageable pageable,
                                         @RequestParam(required = false, defaultValue = "") String searchCode,
                                         @RequestParam(required = false, defaultValue = "") String searchName,
                                         @RequestParam(required = false, defaultValue = "") String searchPhoneNumber) {

        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<CustomerDTO> customerDTOS = this.customerService.searchCustomer(sortedPageaBle, searchCode, searchName, searchPhoneNumber);

        if (customerDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }

    /**
     * Function delete customer
     * @param id
     */
//    @ResponseStatus(HttpStatus.OK)
//    @DeleteMapping("")
//    public void delete(@RequestParam(required = false) Integer id) {
//        customerService.deleteCustomer(id);
//    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }
}
