package vn.codegym.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.entity.employee.Employee;
import vn.codegym.service.employee.IEmployeeService;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;
    /** display function employee
     *param: not param
     * if list employee is empty
     * *@return httpStatusCode = 204
     * otherwise list employee
     * *@return httpStatusCode = 200
     */
    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll(){
        List<Employee> employees = employeeService.getAll();
        if (employees.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(employees,HttpStatus.OK);
        }

    }
}