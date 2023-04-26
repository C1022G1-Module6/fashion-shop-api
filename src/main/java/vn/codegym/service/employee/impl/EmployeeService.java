package vn.codegym.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.entity.employee.Employee;
import vn.codegym.repository.employee.IEmployeeRepository;
import vn.codegym.service.employee.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}
