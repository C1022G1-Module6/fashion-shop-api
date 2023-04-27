package vn.codegym.controller.customer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.entity.customer.Customer;
import vn.codegym.entity.customer.CustomerType;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.customer.ICustomerTypeService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
//        Map<String,String> check = iCustomerService.checkCreate(customerDTO);
//        if (check.get("errorCode") != null) {
//            bindingResult.rejectValue("code", "code", check.get("errorCode"));
//        }
//        if (check.get("errorPhone") != null) {
//            bindingResult.rejectValue("phoneNumber", "phoneNumber", check.get("errorPhone"));
//        }
//
//        if (check.get("errorEmail") != null) {
//            bindingResult.rejectValue("email", "email", check.get("errorEmail"));
//        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);

        customerService.saveCustomer(customer.getCode(),customer.getName(),customer.isGender(),customer.getDateOfBirth(),
                customer.getAddress(),customer.getEmail(),customer.getPhoneNumber(),customer.getPoint(),customer.getCustomerType().getId());
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
//        Map<String, String> check = iCustomerService.checkUpdate(customerDTO);
//        if (check.get("errorCode") != null) {
//            bindingResult.rejectValue("code", "code", check.get("errorCode"));
//        }
//        if (check.get("errorPhone") != null) {
//            bindingResult.rejectValue("phoneNumber", "phoneNumber", check.get("errorPhone"));
//        }
//        if (check.get("errorEmail") != null) {
//            bindingResult.rejectValue("email", "email", check.get("errorEmail"));
//        }
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
