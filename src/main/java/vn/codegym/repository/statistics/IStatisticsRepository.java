package vn.codegym.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.invoice.Invoice;
import vn.codegym.projections.IStatisticsProjection;

import java.util.List;

public interface IStatisticsRepository extends JpaRepository<Invoice, Integer> {
    @Query(value = "select format(day(invoice.date), '00') as `day`, sum(payment) as revenue from invoice\n" +
            "            where month(invoice.date) like %:id% \n" +
            "            group by `day`,  month(invoice.date) ", nativeQuery = true)
    List<IStatisticsProjection> listAllStatisticsProjection(@Param("id") Integer month );
}
