package vn.codegym.service.statistics;

import vn.codegym.projections.*;

import java.util.List;

public interface IStatisticsService {
    List<IStatisticsProjection> findAll(Integer month);

    List<IMonthRevenueProjection> monthRevenue(Integer month);

    List<IDayCostProjection> dayCost(Integer month);

    List<IMonthCostProjection> monthCost(Integer month);

    List<IDayProfitProjection> dayProfit(Integer month);

    List<IMonthProfitProjection> monthProfit(Integer month);
}
