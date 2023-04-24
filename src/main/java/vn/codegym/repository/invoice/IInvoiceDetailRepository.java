package vn.codegym.repository.invoice;

import vn.codegym.entity.invoice.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
}
