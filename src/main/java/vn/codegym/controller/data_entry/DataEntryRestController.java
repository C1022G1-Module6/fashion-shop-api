package vn.codegym.controller.data_entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.service.data_entry.IDataEntryProductService;
import vn.codegym.service.data_entry.IDataEntryService;
import vn.codegym.service.data_entry.impl.DataEntryProductServiceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/date-entry")
@CrossOrigin("*")
public class DataEntryRestController {
    @Autowired
    private IDataEntryService iDataEntryService;
    @Autowired
    private DataEntryProductServiceImpl dataEntryProductService;

    /**
     * this method is applied to send a List of data entry instances and a HttpStatus
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> getAllList(){
        try {
            List<DataEntryDTO> dataEntryDTOList = iDataEntryService.findAll();
            return new ResponseEntity<>(dataEntryDTOList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * this method is applied to update info of data entry instance with the param get from client and send HttpStatus
     * @param dataEntryDTO
     * @return
     */
    @PutMapping ("")
    public ResponseEntity<?> updateEntryProducts(@RequestBody DataEntryDTO dataEntryDTO){
        try {
            iDataEntryService.update(dataEntryDTO);
            dataEntryProductService.resetCount();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
