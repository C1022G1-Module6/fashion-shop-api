package vn.codegym.controller.data_entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.data_entry.DataEntryProductDTO;
import vn.codegym.service.data_entry.IDataEntryProductService;

import java.util.List;

@RestController
@RequestMapping("/data-entry-product")
@CrossOrigin("*")
public class DataEntryProductRestController {
    @Autowired
    private IDataEntryProductService iDataEntryProductService;

    @PostMapping("")
    public ResponseEntity<?> createDataEntryProduct(@RequestBody DataEntryProductDTO dataEntryProductDTO){
//        try {
            iDataEntryProductService.saveEntryProduct(dataEntryProductDTO);
            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }

    @GetMapping("")
    public ResponseEntity<?> listALl(){
//        try {
            List<DataEntryProductDTO> dataEntryProductDTOList = iDataEntryProductService.findAll();
            return new ResponseEntity<>(dataEntryProductDTOList, HttpStatus.OK);
//        } catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }
}
