package vn.codegym.controller.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<?> listAll() {
        try {
            List<IStatisticsProjection> statisticsProjectionList = iStatisticsService.findAll();
            return new ResponseEntity<>(statisticsProjectionList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
