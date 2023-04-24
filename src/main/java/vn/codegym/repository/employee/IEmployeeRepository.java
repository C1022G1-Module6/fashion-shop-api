package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Modifying
    @Query(value = "select *  from employee   ", nativeQuery = true)
    List<Employee> getAll();
}
