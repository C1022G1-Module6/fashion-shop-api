package vn.codegym.controller.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.entity.customer.Customer;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.customer.ICustomerTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    ICustomerTypeService customerTypeService;

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
    public ResponseEntity<Page<CustomerDTO>> search(@PageableDefault(sort = {"id"},direction = Sort.Direction.DESC, size = 5) Pageable pageable,
                                         @RequestParam(required = false, defaultValue = "") String searchCode,
                                         @RequestParam(required = false, defaultValue = "") String searchName,
                                         @RequestParam(required = false, defaultValue = "") String searchPhoneNumber) {

//        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<CustomerDTO> customerDTOS = this.customerService.searchCustomer(pageable, searchCode, searchName, searchPhoneNumber);

        if (customerDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }

    /**
     * Created by: TienTHM
     * Date created: 24/04/2023
     * Function: add data customer  into Database
     *
     * @return if has errors then return HttpStatus.Not_FOUND else add data into Database
     */
    @PostMapping(value = {"/create"} )
    public ResponseEntity<?> createCustomer(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){
        new CustomerDTO().validate(customerDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }


        customerService.saveCustomer(customerDTO.getCode(),customerDTO.getName(),customerDTO.isGender(),customerDTO.getDateOfBirth(),
                customerDTO.getAddress(),customerDTO.getEmail(),customerDTO.getPhoneNumber(),0,2);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> findByCustomerId(@PathVariable Integer id) {
        Customer customer = customerService.findByCustomerId(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Created by: TienTHM
     * Date created: 24/04/2023
     * Function: edit customer data if ID is not found then return HttpStatus.NOT_FOUND,
     * if found ID then edit data in DB and return HttpStatus.OK
     *
     * @return if has errors then return HttpStatus.Not_FOUND else add data into DB
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Integer id, @Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        customerDTO.setId(id);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customer = customerService.findByCustomerId(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            customerService.updateCustomer(customerDTO.getCode(),customerDTO.getName(),customerDTO.isGender(),customerDTO.getDateOfBirth(),
                    customerDTO.getAddress(),customerDTO.getEmail(),customerDTO.getPhoneNumber(),customerDTO.getPoint(),customerDTO.getCustomerTypeDTO().getId(),id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
