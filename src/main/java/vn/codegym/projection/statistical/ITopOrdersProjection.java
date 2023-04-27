package vn.codegym.projection.statistical;

public interface ITopOrdersProjection {

        String getName();

        Integer getQuantity();




//    SELECT p.id AS product_id, p.code, p.name, SUM(id.quantity) AS quantity
//    FROM product p
//    JOIN invoice_detail id ON p.id = id.product_id
//    GROUP BY p.id
//    ORDER BY total_quantity_sold DESC
//    LIMIT 5;

}
