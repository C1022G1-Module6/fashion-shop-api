package vn.codegym.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.customer.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    /**
     * Customer search function with isDelete parameter supports soft deletion
     *
     * @param pageable
     * @param code
     * @param name
     * @param phoneNumber
     * @param isDelete
     * @return function returns page containing customer data information
     */;
    @Query(value = "SELECT * FROM customer c WHERE (c.code LIKE CONCAT('%', :code, '%') " +
            "OR c.name LIKE CONCAT('%', :name, '%') " +
            "OR c.phone_number LIKE CONCAT('%', :phoneNumber, '%')) " +
            "AND c.is_delete = false", nativeQuery = true)
    Page<Customer> searchCustomerInfo(Pageable pageable,
                                      @Param("code") String code,
                                      @Param("name") String name,
                                      @Param("phoneNumber") String phoneNumber);

    /**
     * Search for customers by id
     *
     * @param id
     * @return the object corresponding to the passed id
     */
    @Query(value = "select * from customer where id like concat('%', :id, '%')", nativeQuery = true)
    Customer findByCustomerId(@Param("id") int id);
    @Query(value = "select * from customer where code like concat('%', :code, '%')", nativeQuery = true)
    Customer findCustomerWithCode(@Param("code") String code);
}
