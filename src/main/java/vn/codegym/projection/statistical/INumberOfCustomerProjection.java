package vn.codegym.projection.statistical;



import java.util.Date;

public interface INumberOfCustomerProjection {
    /**
     * Lấy ID theo số lần khách mua hàng
     *
     *
     */
    Long getCurrent();
    Long getLast();
    Long getPercent();

}
