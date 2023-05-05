package vn.codegym.repository.statistical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.entity.product.Product;
import vn.codegym.projection.statistical.ITopOrdersProjection;

import java.util.List;

public interface IProductStatisticalRepository extends JpaRepository<Product, Integer> {
    /**
     * Lấy top 5 hàng hóa bán chạy nhất theo quý
     * @return
     */
    @Query(value = "SELECT p.name, p.img, CONCAT('Quý ', QUARTER(i.date),' năm ',YEAR(i.date)) AS quarter, SUM(id.quantity) AS quantity\n" +
            "FROM product p\n" +
            "JOIN invoice_detail id ON p.id = id.product_id\n" +
            "JOIN invoice i ON i.id = id.invoice_id\n" +
            "GROUP BY p.id, quarter\n" +
            "ORDER BY quarter ASC, quantity DESC\n" +
            "LIMIT 5;", nativeQuery = true)
    List<ITopOrdersProjection> findTopOrders();



}
