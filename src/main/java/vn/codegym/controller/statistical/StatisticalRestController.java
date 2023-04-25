package vn.codegym.controller.statistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.projection.statistical.*;
import vn.codegym.service.customer.ICustomerService;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.invoice.IInvoiceDetailService;
import vn.codegym.service.invoice.IInvoiceService;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin("*")
public class StatisticalRestController {

    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IInvoiceService iInvoiceService;
    @Autowired
    private IInvoiceDetailService iInvoiceDetailService;
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/customer")
    public ResponseEntity<List<INumberOfCustomerProjection>> getNumberOfCustomer() {
        List<INumberOfCustomerProjection> iNumberOfCustomerProjections = iInvoiceService.findAllCustomer();
        if (iNumberOfCustomerProjections == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iNumberOfCustomerProjections, HttpStatus.OK);
        }
    }

//    @GetMapping("")
//    public ResponseEntity<List<INumberOfOrdersProjection>> getNumberOfOrders() {
//        List<INumberOfOrdersProjection> iNumberOfOrdersProjections = iCustomerService.findNumberOfCustomer();
//        if (iNumberOfOrdersProjections == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(iNumberOfOrdersProjections, HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("")
//    public ResponseEntity<List<ITopEmployeesProjection>> getTopEmployees() {
//        List<ITopEmployeesProjection> iTopEmployeesProjections = iCustomerService.findNumberOfCustomer();
//        if (iTopEmployeesProjections == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(iTopEmployeesProjections, HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("")
//    public ResponseEntity<List<ITopOrdersProjection>> getTopOrders() {
//        List<ITopOrdersProjection> iTopOrdersProjections = iCustomerService.findNumberOfCustomer();
//        if (iTopOrdersProjections == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(iTopOrdersProjections, HttpStatus.OK);
//        }
//    }
    @GetMapping("/total")
    public Double getTotalRevenue(@RequestParam("startDate") String startDate,
                                  @RequestParam("endDate") String endDate) {
        return iInvoiceService.getTotalRevenues(startDate,endDate);
    }
}
