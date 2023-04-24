package vn.codegym.repository.customer;

import vn.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where code like concat('%', :code, '%') " +
            "and name like concat('%', :name, '%') " +
            "and phone_number like concat('%', :phoneNumber, '%')", nativeQuery = true)
    Page<Customer> searchCustomerInfo(Pageable pageable,
                                      @Param("code") String code,
                                      @Param("name") String name,
                                      @Param("phoneNumber") String phoneNumber);
}
