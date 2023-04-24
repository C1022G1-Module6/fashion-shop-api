package vn.codegym.repository.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.employee.Employee;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to find username
     * @param username
     * @return Employee
     *
     */
    @Query(value = "SELECT * FROM employee WHERE user_name = :username", nativeQuery = true)
    Optional<Employee> findByUsername(@Param("username") String username);
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to check username exists or not
     * @param username
     * @return
     * If username exists, return true, else false
     */
    @Query(value = "SELECT IF(EXISTS(SELECT * FROM employee WHERE user_name = :username), 'true', 'false')", nativeQuery = true)
    Boolean existsByUserName(@Param("username") String username);
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to check email exists or not
     * @param email
     * @return
     * If email exists, return true, else false
     */
    @Query(value = "SELECT IF(EXISTS(SELECT * FROM employee WHERE email = :email), 'true', 'false')", nativeQuery = true)
    Boolean existsByEmail(@Param("email") String email);
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method to change password
     * @param id
     * @param newPassword
     * @return void
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE employee SET password = :newPassword WHERE id = :id",nativeQuery = true)
    void updatePassword(@Param("newPassword")String newPassword,@Param("id")Integer id);

}