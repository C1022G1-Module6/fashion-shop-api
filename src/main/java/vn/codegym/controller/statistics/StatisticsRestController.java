package vn.codegym.controller.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.response.ResponseMessage;
import vn.codegym.projections.IDayCostProjection;
import vn.codegym.projections.IMonthCostProjection;
import vn.codegym.projections.IMonthRevenueProjection;
import vn.codegym.projections.IStatisticsProjection;
import vn.codegym.projections.*;
import vn.codegym.service.statistics.IStatisticsService;

import javax.mail.Message;
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

    @GetMapping("/cost")
    public ResponseEntity<?> dayCost(@RequestParam(required = false, defaultValue = "") Integer month) {
        try {
            List<IDayCostProjection> iDayCostProjectionList = iStatisticsService.dayCost(month);
            return new ResponseEntity<>(iDayCostProjectionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/month-cost")
    public ResponseEntity<?> monthCost(@RequestParam(required = false, defaultValue = "") Integer month) {
        try {
            List<IMonthCostProjection> iMonthCostProjectionList = iStatisticsService.monthCost(month);
            return new ResponseEntity<>(iMonthCostProjectionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/profit")
    public ResponseEntity<?> dayProfit(@RequestParam(required = false, defaultValue = "") Integer month) {
        try {
            List<IDayProfitProjection> iDayProfitProjectionList = iStatisticsService.dayProfit(month);
            return new ResponseEntity<>(iDayProfitProjectionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/month-profit")
    public ResponseEntity<?> monthProfit(@RequestParam(required = false, defaultValue = "") Integer month) {
        try {
            List<IMonthProfitProjection> iMonthProfitProjectionList = iStatisticsService.monthProfit(month);
            return new ResponseEntity<>(iMonthProfitProjectionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
