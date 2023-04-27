package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.entity.customer.CustomerType;

import java.util.List;

import java.util.List;
@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    /**
     * Function to get all kinds of customer information
     * @return customer type list
     */;
    @Query(value = "select * from customer_type", nativeQuery = true)
    List<CustomerType> findAllCustomerType();

}
