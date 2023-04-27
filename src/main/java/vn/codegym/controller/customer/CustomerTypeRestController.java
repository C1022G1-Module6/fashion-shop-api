package vn.codegym.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.entity.customer.Customer;
import vn.codegym.entity.customer.CustomerType;
import vn.codegym.service.customer.ICustomerTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/customerType")
@CrossOrigin("*")
public class CustomerTypeRestController {
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public ResponseEntity<List<CustomerType>> getAll(){
        List<CustomerType> list = iCustomerTypeService.findAll();
        if (list == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
