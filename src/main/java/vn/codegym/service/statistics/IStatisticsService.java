package vn.codegym.service.statistics;

import vn.codegym.projections.IMonthRevenueProjection;
import vn.codegym.projections.IStatisticsProjection;

import java.util.List;

public interface IStatisticsService {
    List<IStatisticsProjection> findAll(Integer month);

    List<IMonthRevenueProjection> monthRevenue(Integer month);
}