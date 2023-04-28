package vn.codegym.repository.statistical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.entity.invoice.Invoice;
import vn.codegym.projection.statistical.INumberOfCustomerProjection;
import vn.codegym.projection.statistical.INumberOfOrdersProjection;
import vn.codegym.projection.statistical.ITopEmployeesProjection;

import java.util.List;
@Repository
public interface IInvoiceStatisticalRepository extends JpaRepository<Invoice, Integer> {
    /**
     * Lấy tổng doanh thu
     *
     */
    @Query(value = "SELECT SUM(payment) AS total_revenue FROM invoice",nativeQuery = true)
    Double getTotalRevenue();


    /**
     * Lấy top 5 nhân viên bán chạy nhất
     * @return
     */
    @Query(value = "SELECT i.employee_name as name, SUM(i.payment) payment, SUM(iv.total) AS total\n" +
            "FROM invoice i\n" +
            "JOIN invoice_detail iv ON iv.id = i.id\n" +
            "GROUP BY name\n" +
            "ORDER BY payment DESC\n" +
            "LIMIT 5;", nativeQuery = true)
    List<ITopEmployeesProjection> findTopEmployee();


    /**
     * Lấy số lượng đơn hàng đặt và so sánh với tuần trước
     *
     */
    @Query(value = "SELECT \n" +
            "    COUNT(*) AS `current`, \n" +
            "    (SELECT COUNT(*) FROM invoice WHERE WEEK(date) = WEEK(NOW()) - 1) AS `last`,\n" +
            "    ROUND(((COUNT(*) - (SELECT COUNT(*) FROM invoice WHERE WEEK(date) = WEEK(NOW()) - 1)) / (SELECT COUNT(*) FROM invoice WHERE WEEK(date) = WEEK(NOW()) - 1)) * 100) AS percent\n" +
            "FROM invoice\n" +
            "WHERE WEEK(date) = WEEK(NOW());", nativeQuery = true)
    List<INumberOfOrdersProjection> findNumberOfOrders();


    /**
     * Lấy số lượng khách hàng và so sánh với lượng khách hàng tuần trước
     * Hàm COUNT(DISTINCT customer_id) để đếm số lượng khách hàng khác nhau đã xuất hiện trong bảng invoice.
     * WEEK(date) để lấy số tuần của ngày tạo hóa đơn.
     * (WEEK(NOW())) để lọc ra các hóa đơn trong tuần hiện tại.
     * sử dụng một câu con trong SELECT để lấy số lượng khách hàng trong tuần trước
     * và tính phần trăm tăng/giảm so với tuần trước.
     */
    @Query(value = "SELECT \n" +
            "    COUNT(DISTINCT customer_id) AS `current`, \n" +
            "    (SELECT COUNT(DISTINCT customer_id) FROM invoice WHERE WEEK(date) = WEEK(NOW()) - 1) AS `last`,\n" +
            "    ROUND(((COUNT(DISTINCT customer_id) - (SELECT COUNT(DISTINCT customer_id) FROM invoice WHERE WEEK(date) = WEEK(NOW()) - 1)) / (SELECT COUNT(DISTINCT customer_id) FROM invoice WHERE WEEK(date) = WEEK(NOW()) - 1)) * 100) AS percent\n" +
            "FROM invoice\n" +
            "WHERE WEEK(date) = WEEK(NOW());", nativeQuery = true)
    List<INumberOfCustomerProjection> findNumberOfCustomers();
}
