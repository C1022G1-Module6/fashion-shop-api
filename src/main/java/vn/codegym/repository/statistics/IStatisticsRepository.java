package vn.codegym.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.entity.invoice.Invoice;
import vn.codegym.projections.IStatisticsProjection;

import java.util.List;

public interface IStatisticsRepository extends JpaRepository<Invoice, Integer> {
    @Query(value = "select invoice.date as date, sum(payment) as revenue from invoice \n" +
            "where date \n" +
            "group by date;", nativeQuery = true)
    List<IStatisticsProjection> listAllStatisticsProjection();
}
