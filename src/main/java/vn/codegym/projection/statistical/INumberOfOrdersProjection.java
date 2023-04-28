package vn.codegym.projection.statistical;


public interface INumberOfOrdersProjection {
    /**
     *  Lấy ID theo số lần khách mua hàng
     *  Lấy ngày để so sánh số lượng khách hàng tăng theo từng tháng or tuần
     * @return
     */
    Long getCurrent();
    Long getLast();
    Long getPercent();

}
