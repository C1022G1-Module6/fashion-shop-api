package vn.codegym.service.statistics.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.projections.IStatisticsProjection;
import vn.codegym.repository.statistics.IStatisticsRepository;
import vn.codegym.service.statistics.IStatisticsService;

import java.util.List;
@Service
public class StatisticsServiceImpl implements IStatisticsService {
    @Autowired
    private IStatisticsRepository iStatisticsRepository;

    @Override
    public List<IStatisticsProjection> findAll(Integer month) {
        List<IStatisticsProjection> iStatisticsProjectionList = iStatisticsRepository.listAllStatisticsProjection(month);
        return iStatisticsProjectionList;
    }
    /**
     * This method is used to display the list IStatisticsProjection
     * @return
     */

}
