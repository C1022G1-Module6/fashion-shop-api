package vn.codegym.controller.employee;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.employee.EmployeeDTO;
import vn.codegym.dto.response.ResponseMessage;
import vn.codegym.entity.employee.Employee;
import vn.codegym.service.employee.IEmployeeService;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * QuanNLA
     * Date 24/04/2023
     * Method that finds username and returns user information
     * @param username
     * @return
     * If checking the username does not match, it will return message "Tên người dùng không tồn tại"
     * If check username match, it will return EmployeeDTO object and HttpStatus.OK
     */
    @GetMapping("detail")
    public ResponseEntity<?> detail(@RequestParam(required = false,defaultValue = "")String username){
        if(!iEmployeeService.existsByUsername(username)){
            return new ResponseEntity<>(new ResponseMessage("Tên người dùng không tồn tại")
                    , HttpStatus.BAD_REQUEST);
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Optional<Employee> employee = iEmployeeService.findByUsername(username);
        BeanUtils.copyProperties(employee.get(),employeeDTO);
        return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
    }
}
