package vn.codegym.controller.statistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.projection.statistical.*;
import vn.codegym.service.statistical.IStatiscialService;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin("*")
public class StatisticalRestController {

    @Autowired
    private IStatiscialService iStatiscialService;

    /**
     *Phương thức này để gửi số lượng khách hàng
     * @return nếu không có dữ liệu thì gửi status NO_CONTENT
     * @return nếu có dữ liệu thì gửi status OK và trả về dữ liệu
     */

    @GetMapping("/customer")
    public ResponseEntity<List<INumberOfCustomerProjection>> getNumberOfCustomer() {
        List<INumberOfCustomerProjection> iNumberOfCustomerProjections = iStatiscialService.findNumberOfCustomers();
        if (iNumberOfCustomerProjections == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iNumberOfCustomerProjections, HttpStatus.OK);
        }
    }
    /**
     *Phương thức này để gửi số lượng đơn hàng
     * @return nếu không có dữ liệu thì gửi status NO_CONTENT
     * @return nếu có dữ liệu thì gửi status OK và trả về dữ liệu
     */
    @GetMapping("/order")
    public ResponseEntity<List<INumberOfOrdersProjection>> getNumberOfOrders() {
        List<INumberOfOrdersProjection> iNumberOfOrdersProjections = iStatiscialService.findNumberOfOrders();
        if (iNumberOfOrdersProjections == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iNumberOfOrdersProjections, HttpStatus.OK);
        }
    }

    /**
     *Phương thức này để gửi top nhân viên baán hàng tốt nhất
     * @return nếu không có dữ liệu thì gửi status NO_CONTENT
     * @return nếu có dữ liệu thì gửi status OK và trả về dữ liệu
     */
    @GetMapping("top-selling")
    public ResponseEntity<List<ITopEmployeesProjection>> getTopEmployees() {
        List<ITopEmployeesProjection> iTopEmployeesProjections = iStatiscialService.findEmployee();
        if (iTopEmployeesProjections == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iTopEmployeesProjections, HttpStatus.OK);
        }
    }

    /**
     *Phương thức này để gửi top 5 loại hàng hóa bán nhiều nhất
     * @return nếu không có dữ liệu thì gửi status NO_CONTENT
     * @return nếu có dữ liệu thì gửi status OK và trả về dữ liệu
     */
    @GetMapping("top-order")
    public ResponseEntity<List<ITopOrdersProjection>> getTopOrders() {
        List<ITopOrdersProjection> iTopOrdersProjections = iStatiscialService.findOrders();
        if (iTopOrdersProjections == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(iTopOrdersProjections, HttpStatus.OK);
        }
    }


    /**
     *Phương thức này để tính doanh thu shop
     *
     * @return nếu có dữ liệu trả về dữ liệu
     */
    @GetMapping("/total")
    public Double getTotalRevenue() {
        return iStatiscialService.getTotalRevenues();
    }
}
