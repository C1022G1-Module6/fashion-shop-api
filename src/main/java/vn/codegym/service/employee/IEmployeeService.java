package vn.codegym.service.employee;
import vn.codegym.entity.employee.Employee;
import java.util.Optional;

import vn.codegym.entity.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to find username
     * @param name
     * @return Employee
     *
     */
    Optional<Employee> findByUsername(String name);
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to check username exists or not
     * @param username
     * @return
     * If username exists, return true, else false
     */
    Boolean existsByUsername(String username);
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to check email exists or not
     * @param email
     * @return
     * If email exists, return true, else false
     */
    Boolean existsByEmail(String email);
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to check password exists or not
     * @param oldPassword
     * @param employee
     * @return
     * If password exists, return true, else false
     */
    Boolean checkIfValidOldPassword(Employee employee, String oldPassword);
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to change password
     * @param employee
     * @param newPassword
     * @return void
     */
    void changeUserPassword(Employee employee,String newPassword);

    List<Employee> getAll();
}
