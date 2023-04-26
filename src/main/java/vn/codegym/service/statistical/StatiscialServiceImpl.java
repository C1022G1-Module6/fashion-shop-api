package vn.codegym.service.statistical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.projection.statistical.INumberOfCustomerProjection;
import vn.codegym.projection.statistical.INumberOfOrdersProjection;
import vn.codegym.projection.statistical.ITopEmployeesProjection;
import vn.codegym.projection.statistical.ITopOrdersProjection;
import vn.codegym.repository.statistical.IInvoiceStatisticalRepository;
import vn.codegym.repository.statistical.IProductStatisticalRepository;

import java.util.List;
@Service
public class StatiscialServiceImpl implements IStatiscialService {

    @Autowired
    IInvoiceStatisticalRepository iInvoiceStatiscialRepository;

    @Autowired
    IProductStatisticalRepository iProductStatiscialRepository;

    @Override
    public Double getTotalRevenues() {
        return iInvoiceStatiscialRepository.getTotalRevenue();
    }

    @Override
    public List<ITopEmployeesProjection> findEmployee() {
        return iInvoiceStatiscialRepository.findTopEmployee();
    }

    @Override
    public List<ITopOrdersProjection> findOrders() {
        return iProductStatiscialRepository.findTopOrders();
    }

    @Override
    public List<INumberOfOrdersProjection> findNumberOfOrders() {
        return iInvoiceStatiscialRepository.findNumberOfOrders();
    }

    @Override
    public List<INumberOfCustomerProjection> findNumberOfCustomers() {
        return iInvoiceStatiscialRepository.findNumberOfCustomers();
    }
}
