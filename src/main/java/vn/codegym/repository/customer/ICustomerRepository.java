package vn.codegym.repository.customer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * Create by: TienTHM,
     * Date create : 24/04/2023
     * Function : Add new customer to database
     *
     * @Param("code") String code,
     * @Param("name") String name,
     * @Param("gender") boolean gender,
     * @Param("date_of_birth") String dateOfBirth,
     * @Param("address") String address,
     * @Param("email") String email,
     * @Param("phone_number") String phoneNumber,
     * @Param("point") Integer point,
     */
    @Transactional
    @Modifying
    @Query(value = "insert into customer( code, name, gender,date_of_birth, address, email, phone_number, point, is_delete,customer_type_id) " +
            "value (:code, :name, :gender, :dateOfBirth, :address, :email, :phoneNumber, :point, false,:customerTypeId)",
            nativeQuery = true)
    void saveCustomer(
            @Param("code") String code,
            @Param("name") String name,
            @Param("gender") boolean gender,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("address") String address,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber,
            @Param("point") Integer point,
            @Param("customerTypeId") Integer customerTypeId);


    //    /**
//     * Created by: TienTHM
//     * Date created: 24/04/2023
//     * Function: find all customer
//     *
//     * @return
//     */
    @Modifying
    @Query(value = "select * from customer", nativeQuery = true)
    List<Customer> findAllCustomer();


    /**
     * Created by: TienTHM
     * Date created: 24/04/2023
     * Function: find id customer
     *
     * @return call to updateCustomer in iCustomerRepository
     */
    @Query(value = "select c.* from customer c join `customer_type` ct on ct.id = c.customer_type_id  where is_delete = false and c.id =:id", nativeQuery = true)
    Customer findCustomerById(@Param("id") Integer id);



    /**
     * Create by: TienTHM,
     * Date create : 24/04/2023
     * Function : Edit customers in database
     *
     * @param code
     * @param name
     * @param gender
     * @param dateOfBirth
     * @param address
     * @param email
     * @param phoneNumber
     * @param point
     * @param customerTypeId
     * @param id
     */
    @Transactional
    @Modifying
    @Query(value = "update customer " +
            "set code = :code," +
            "name = :name," +
            "gender = :gender," +
            "date_of_birth = :dateOfBirth," +
            "address = :address," +
            "email = :email," +
            "phone_number = :phoneNumber," +
            "point = :point," +
            "customer_type_id = :customerTypeId" +
            " WHERE id = :id",
            nativeQuery = true)
    void updateCustomer(
            @Param("code") String code,
            @Param("name") String name,
            @Param("gender") boolean gender,
            @Param("dateOfBirth") String dateOfBirth,
            @Param("address") String address,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber,
            @Param("point") Integer point,
            @Param("customerTypeId") Integer customerTypeId,
            @Param("id") Integer id
    );

}
