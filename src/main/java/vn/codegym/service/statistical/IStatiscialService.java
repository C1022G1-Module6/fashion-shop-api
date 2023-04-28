package vn.codegym.service.statistical;

import vn.codegym.projection.statistical.INumberOfCustomerProjection;
import vn.codegym.projection.statistical.INumberOfOrdersProjection;
import vn.codegym.projection.statistical.ITopEmployeesProjection;
import vn.codegym.projection.statistical.ITopOrdersProjection;

import java.util.List;

public interface IStatiscialService {
    Double getTotalRevenues();

    List<ITopEmployeesProjection> findEmployee();

    List<ITopOrdersProjection> findOrders();

    List<INumberOfOrdersProjection> findNumberOfOrders();
    List<INumberOfCustomerProjection> findNumberOfCustomers();

}
