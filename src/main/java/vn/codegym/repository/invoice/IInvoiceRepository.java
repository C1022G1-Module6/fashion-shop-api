package vn.codegym.repository.invoice;

import vn.codegym.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
}
