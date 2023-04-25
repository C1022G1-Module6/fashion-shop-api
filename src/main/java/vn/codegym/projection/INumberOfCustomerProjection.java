package vn.codegym.projection;

import java.util.Date;

public interface INumberOfCustomerProjection {
    /**
     * Lấy ID theo số lần khách mua hàng
     *  Lấy ngày để so sánh số lượng khách hàng tăng theo từng tháng or tuần
     * @return
     */
    Integer getId();
    InvoiceWithDate invoices();
    interface InvoiceWithDate {
        Date getDate();
    }
}
