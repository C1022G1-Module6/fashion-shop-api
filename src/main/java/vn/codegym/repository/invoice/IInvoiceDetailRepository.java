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
    @Query(value = "insert into invoice_detail (quantity, total, invoice_id, product_id, is_delete, `size`, product_size_code) " +
            "values (:quantity, :total, :invoice, :product, :isDelete, :size, :productSizeCode)", nativeQuery = true)
    void saveInvoiceDetail(@Param("quantity") Integer quantity,
                           @Param("total") Double total,
                           @Param("invoice") Integer invoiceId,
                           @Param("product") Integer productId,
                           @Param("size") String size,
                           @Param("productSizeCode") String productSizeCode,
                           @Param("isDelete") Boolean isDelete);

    @Query(value = "select * from invoice_detail where id = :id", nativeQuery = true)
    InvoiceDetail findDetailWithId(@Param("id") Integer id);
    @Query(value = "select  * from invoice_detail where invoice_id = :id and is_delete = false", nativeQuery = true)
    List<InvoiceDetail> getAllWithId(@Param("id") Integer id);

}
