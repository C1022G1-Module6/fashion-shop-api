package vn.codegym.controller.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.projections.IMonthRevenueProjection;
import vn.codegym.projections.IStatisticsProjection;
import vn.codegym.service.statistics.IStatisticsService;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@CrossOrigin("*")
public class StatisticsRestController {
    @Autowired
    private IStatisticsService iStatisticsService;

    /**
     * this method is applied to send a List of data statistics instances and a HttpStatus
     *
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> listAll(@RequestParam(required = false, defaultValue = "") Integer month) {
        try {
            List<IStatisticsProjection> statisticsProjectionList = iStatisticsService.findAll(month);
            return new ResponseEntity<>(statisticsProjectionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * This method is used to get monthly revenue data with the month parameter passed in
     * @param month
     * @return
     */
    @GetMapping("/month-revenue")
    public ResponseEntity<?> monthRevenue(@RequestParam(required = false, defaultValue = "") Integer month) {
        try {
            List<IMonthRevenueProjection> iMonthRevenueProjectionList = iStatisticsService.monthRevenue(month);
            return new ResponseEntity<>(iMonthRevenueProjectionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
