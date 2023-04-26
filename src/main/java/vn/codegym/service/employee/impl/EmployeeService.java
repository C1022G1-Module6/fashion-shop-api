package vn.codegym.service.employee.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.entity.employee.Employee;
import vn.codegym.repository.employee.IEmployeeRepository;
import vn.codegym.service.employee.IEmployeeService;
import org.springframework.stereotype.Service;
import vn.codegym.entity.employee.Employee;
import vn.codegym.repository.employee.IEmployeeRepository;
import vn.codegym.service.employee.IEmployeeService;

import java.util.Optional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;
    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to find username
     * @param name
     * @return Employee
     *
     */
    @Override
    public Optional<Employee> findByUsername(String name) {
        return iEmployeeRepository.findByUsername(name);
    }

    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to check username exists or not
     * @param username
     * @return
     * If username exists, return true, else false
     */
    @Override
    public Boolean existsByUsername(String username) {
        return iEmployeeRepository.existsByUserName(username);
    }
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to check email exists or not
     * @param email
     * @return
     * If email exists, return true, else false
     */
    @Override
    public Boolean existsByEmail(String email) {
        return iEmployeeRepository.existsByEmail(email);
    }

    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to check password exists or not
     * @param oldPassword
     * @param employee
     * @return
     * If password exists, return true, else false
     */
    @Override
    public Boolean checkIfValidOldPassword(Employee employee, String oldPassword) {
        return passwordEncoder.matches(oldPassword, employee.getPassword());
    }
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to change password
     * @param employee
     * @param newPassword
     * @return void
     */
    @Override
    public void changeUserPassword(Employee employee, String newPassword) {
        employee.setPassword(passwordEncoder.encode(newPassword));
        iEmployeeRepository.updatePassword(employee.getPassword(),employee.getId());
    }
    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
}


}