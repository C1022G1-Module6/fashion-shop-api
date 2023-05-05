package vn.codegym.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.entity.customer.CustomerType;
import vn.codegym.service.customer.ICustomerTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/customerType")
@CrossOrigin("*")
public class CustomerTypeRestController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    /**
     * Function to display all types of customers
     * @return if customer type list is empty then return status No_Content
     *         if customer type list has value then return customer type list and status OK
     */
    @GetMapping("")

    public ResponseEntity<List<CustomerType>> showList() {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        if (customerTypeList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
        }
    }
}
