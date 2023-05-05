package vn.codegym.service.statistics.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.projections.IDayCostProjection;
import vn.codegym.projections.IMonthCostProjection;
import vn.codegym.projections.IMonthRevenueProjection;
import vn.codegym.projections.IStatisticsProjection;
import vn.codegym.repository.statistics.IStatisticsRepository;
import vn.codegym.service.statistics.IStatisticsService;

import java.util.List;

@Service
public class StatisticsServiceImpl implements IStatisticsService {
    @Autowired
    private IStatisticsRepository iStatisticsRepository;

    /**
     * This method is used to display the list IStatisticsProjection
     *
     * @return return a iStatisticsProjectionList
     */
    @Override
    public List<IStatisticsProjection> findAll(Integer month) {
        List<IStatisticsProjection> iStatisticsProjectionList = iStatisticsRepository.listAllStatisticsProjection(month);
        return iStatisticsProjectionList;
    }

    /**
     * This method is used to get a month's revenue data
     * @param month
     * @return return a iMonthRevenueProjectionList
     */
    @Override
    public List<IMonthRevenueProjection> monthRevenue(Integer month) {
        List<IMonthRevenueProjection> iMonthRevenueProjectionList = iStatisticsRepository.totalRevenueMonth(month);
        return iMonthRevenueProjectionList;
    }

    @Override
    public List<IDayCostProjection> dayCost(Integer month) {
        List<IDayCostProjection> iDayCostProjectionList = iStatisticsRepository.totalCostDay(month);
        return iDayCostProjectionList;
    }

    @Override
    public List<IMonthCostProjection> monthCost(Integer month) {
        List<IMonthCostProjection> iMonthCostProjectionList = iStatisticsRepository.totalCostMonth(month);
        return iMonthCostProjectionList;
    }
}
