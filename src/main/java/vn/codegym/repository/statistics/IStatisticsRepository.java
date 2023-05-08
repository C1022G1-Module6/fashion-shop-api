package vn.codegym.repository.statistics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.invoice.Invoice;
import vn.codegym.projections.*;

import java.util.List;

public interface IStatisticsRepository extends JpaRepository<Invoice, Integer> {
    @Query(value = "select format(day(invoice.date), '%d') as `day`, sum(payment) as revenue from invoice\n" +
            "            where month(invoice.date) = :month \n" +
            "            group by `day`,  month(invoice.date) ", nativeQuery = true)
    List<IStatisticsProjection> listAllStatisticsProjection(@Param("month") Integer month);

    @Query(value = "select SUM(payment) as totalRevenue from invoice where month(invoice.date) = :month ",
            nativeQuery = true)
    List<IMonthRevenueProjection> totalRevenueMonth(@Param("month") Integer month);

    @Query(value = "select format(day(data_entry.date), '%d') as `day`, sum(data_entry_product.quantity * product.entry_price) as cost from \n" +
            "            data_entry_product inner join product on data_entry_product.product_id = product.id \n" +
            "            inner join data_entry \n" +
            "            on data_entry_product.data_entry_id = data_entry.id\n" +
            "            where month(data_entry.date) = :month group by data_entry.date, month(data_entry.date) order by data_entry.date", nativeQuery = true)
    List<IDayCostProjection> totalCostDay(@Param("month") Integer month);

    @Query(value = "select sum(dep.quantity * pro.entry_price) as totalCost from data_entry_product dep inner join " +
            "product pro on dep.product_id = pro.id inner join data_entry de on dep.data_entry_id = de.id  " +
            "where month(de.date) = :month \n",
            nativeQuery = true)
    List<IMonthCostProjection> totalCostMonth(@Param("month") Integer month);

    @Query(value = "select format(day(inv.date), '00') as `day`, (sum(inv.payment) - " +
            "(sum(ind.quantity * pro.selling_price))) as profit \n" +
            "from invoice_detail ind inner join product pro on ind.product_id = pro.id\n" +
            "inner join invoice inv on ind.invoice_id = inv.id  where month(inv.date) = :month group by inv.date, " +
            "month(inv.date) order by inv.date", nativeQuery = true)
    List<IDayProfitProjection> totalProfitDay(@Param("month") Integer month);

    @Query(value = "select month(inv.date) AS `month`, (SUM(inv.payment) - SUM(ind.quantity * pro.selling_price)) " +
            "AS totalProfit from invoice_detail ind inner join product pro ON ind.product_id = pro.id\n" +
            "inner join invoice inv ON ind.invoice_id = inv.id where month(inv.date) = :month group by month(inv.date)",
            nativeQuery = true)
    List<IMonthProfitProjection> totalProfitMonth(@Param("month") Integer month);
}
