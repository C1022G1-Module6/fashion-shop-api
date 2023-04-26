package vn.codegym.repository.invoice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.invoice.InvoiceDetail;

import java.util.List;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
    /**
     * This function applied to add new invoice instance to the db with params below
     * @param bonusPoint
     * @param code
     * @param date
     * @param employeeName
     * @param payment
     * @param total
     * @param customerId
     */
    @Modifying
    @Transactional
    @Query(value = "insert into invoice (bonus_point, code,`date`, employee_name, payment, total, customer_id) " +
            "values (:bonusPoint, :code, :date, :employeeName, :payment, :total, :customer)", nativeQuery = true)
    void saveInvoice(@Param("bonusPoint") Integer bonusPoint,
                     @Param("code") String code,
                     @Param("date") String date,
                     @Param("employeeName") String employeeName,
                     @Param("payment") Double payment,
                     @Param("total") Double total,
                     @Param("customer") Integer customerId);

    /**
     * This function get all Invoice and return a list of invoice instances
     * @return
     */
    @Query(value = "select * from invoice", nativeQuery = true)
    List<Invoice> listAllInvoice();

    /**
     * This method applied to update the values of invoice instance with params below
     * @param bonusPoint
     * @param code
     * @param date
     * @param employeeName
     * @param payment
     * @param total
     * @param customerId
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update invoice set bonus_point = :bonusPoint, code = :code, `date` = :date, " +
            "employee_name = :employeeName, payment = :payment, total = :total, customer_id = :customer " +
            "where id = :id", nativeQuery = true)
    void updateInvoice(@Param("bonusPoint") Integer bonusPoint,
                       @Param("code") String code,
                       @Param("date") String date,
                       @Param("employeeName") String employeeName,
                       @Param("payment") Double payment,
                       @Param("total") Double total,
                       @Param("customer") Integer customerId,
                       @Param("id") Integer id);

    @Query(value = "select count(code) from invoice", nativeQuery = true)
    Integer getTotalCodeAmount();

    @Modifying
    @Transactional
    @Query(value = "delete from invoice where id = :id", nativeQuery = true)
    void deleteWithId(@Param("id") Integer id);

}
