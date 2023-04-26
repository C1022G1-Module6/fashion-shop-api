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

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerRestController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService iCustomerTypeService;

    /**
     * Created by: TienTHM
     * Date created: 24/04/2023
     * Function: add data customer  into Database
     *
     * @return if has errors then return HttpStatus.Not_FOUND else add data into Database
     */
    @PostMapping(value = {"/create"} )
    public ResponseEntity<?> createCustomer(@Validated @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){
        /*new CustomerDTO().validate(customerDTO,bindingResult);*/
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

        iCustomerService.saveCustomer(customer.getCode(),customer.getName(),customer.isGender(),customer.getDateOfBirth(),
                customer.getAddress(),customer.getEmail(),customer.getPhoneNumber(),customer.getPoint(),customer.getCustomerType().getId());
        return new ResponseEntity<>(HttpStatus.OK);
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
        Customer customer = iCustomerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            iCustomerService.updateCustomer(customerDTO.getCode(),customerDTO.getName(),customerDTO.isGender(),customerDTO.getDateOfBirth(),
                    customerDTO.getAddress(),customerDTO.getEmail(),customerDTO.getPhoneNumber(),customerDTO.getPoint(),customerDTO.getCustomerType().getId(),id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
