package vn.codegym.projection.statistical;

import java.util.Date;

public interface INumberOfOrdersProjection {
    /**
     * Lấy ID theo số lần khách mua hàng
     *  Lấy ngày để so sánh số lượng khách hàng tăng theo từng tháng or tuần
     * @return
     */
    Integer getId();

    Date getDate();

}
