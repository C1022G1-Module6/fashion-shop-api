package vn.codegym.repository.invoice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.entity.invoice.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into invoice_detail (quantity, total, invoice_id, product_id) " +
            "values (:quantity, :total, :invoice, :product)", nativeQuery = true)
    void saveInvoiceDetail(@Param("quantity") Integer quantity,
                           @Param("total") Double total,
                           @Param("invoice") Integer invoiceId,
                           @Param("product") Integer productId);
    @Query(value = "select * from invoice_detail where is_delete = false", nativeQuery = true)
    List<InvoiceDetail> listAllInvoiceDetail();
    @Query(value = "select * from invoice_detail where id = :id", nativeQuery = true)
    InvoiceDetail findDetailWithId(@Param("id") Integer id);
}
