package vn.codegym.controller.data_entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.service.data_entry.IDataEntryService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/date_entry")
@CrossOrigin("*")
public class DataEntryRestController {
    @Autowired
    private IDataEntryService iDataEntryService;

    /**
     *
     * @param dataEntryDTO
     * @param bindingResult
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> entryProducts(@Validated
                                           @RequestBody DataEntryDTO dataEntryDTO,
                                           BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            iDataEntryService.entryProduct(dataEntryDTO);
        }else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error: errors){
                if (!map.containsKey(error.getField())){
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
