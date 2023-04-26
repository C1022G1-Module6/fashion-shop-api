package vn.codegym.repository.invoice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
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

    @Query(value = "select * from invoice where id = :id", nativeQuery = true)
    Invoice findDetailById(@Param("id") Integer id);

    @Query(value = "select * from invoice", nativeQuery = true)
    List<Invoice> listAllInvoice();

    @Modifying
    @Transactional
    @Query(value = "update invoice set bonus_point = :bonusPoint, code = :code, `date` = :date, " +
            "employee_name = :employeeName, payment = :payment, total = :total, customer_id = :customer" +
            "where id = :id", nativeQuery = true)
    void updateInvoice(@Param("bonusPoint") Integer bonusPoint,
                       @Param("code") String code,
                       @Param("date") String date,
                       @Param("employeeName") String employeeName,
                       @Param("payment") Double payment,
                       @Param("total") Double total,
                       @Param("customer") Integer customerId,
                       @Param("id") Integer id);

}
