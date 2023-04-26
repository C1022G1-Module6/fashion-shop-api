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
    /**
     * This method is used to display the list IStatisticsProjection
     * @return
     */
    @Override
    public List<IStatisticsProjection> findAll() {
        return iStatisticsRepository.listAllStatisticsProjection();
    }
}
