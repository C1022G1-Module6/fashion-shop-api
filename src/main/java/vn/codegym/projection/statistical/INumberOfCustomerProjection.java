package vn.codegym.projection.statistical;



import java.util.Date;

public interface INumberOfCustomerProjection {
    /**
     * Lấy ID theo số lần khách mua hàng
     *
     * @return
     */
    CustomerGetId getCustomer();
    interface CustomerGetId {
        Integer getId();
    }
    Date getDate();

}
