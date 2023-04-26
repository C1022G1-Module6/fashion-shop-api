package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.entity.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
//    /**
//     * Create by: TienTHM,
//     * Date create : 24/04/2023
//     * Function : get all customer type
//     *
//     * @return
//     */
//    @Modifying
//    @Query(value = "select * from customer_type",nativeQuery = true)
//    List<CustomerType> getAllCustomerType();
}
