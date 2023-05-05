package vn.codegym.controller.data_entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.data_entry.DataEntryProductDTO;
import vn.codegym.dto.response.ResponseMessage;
import vn.codegym.service.data_entry.IDataEntryProductService;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/data-entry-product")
@CrossOrigin("*")
public class DataEntryProductRestController {
    @Autowired
    private IDataEntryProductService iDataEntryProductService;

    /**
     * this method to add an object as dataEntryProductDTO and return the result if not true for validation through bindingResult
     *
     * @param dataEntryProductDTO
     * @param bindingResult
     * @return
     */
    @PostMapping("")
    public ResponseEntity<?> createDataEntryProduct(@Valid @RequestBody DataEntryProductDTO dataEntryProductDTO,
                                                    BindingResult bindingResult) {
        if(dataEntryProductDTO.getQuantity()==0){
            return new ResponseEntity<>(new ResponseMessage("Không được bỏ trống"), HttpStatus.BAD_REQUEST);
        }
        if (!bindingResult.hasErrors()) {
            String msg = iDataEntryProductService.saveEntryProduct(dataEntryProductDTO);
            if (!Objects.equals(msg, "")) {
                return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
            }
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        if (dataEntryProductDTO.getProductDTO().getCode() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * this method is applied to send a List of dataEntryProductDTOList instances and a HttpStatus
     *
     * @return
     */
    @GetMapping("")
    public ResponseEntity<List<DataEntryProductDTO>> listALl() {
        List<DataEntryProductDTO> dataEntryProductDTOList = iDataEntryProductService.findAll();
        if (dataEntryProductDTOList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(dataEntryProductDTOList, HttpStatus.OK);
        }
    }

    /**
     * This method is used to delete an object based on the id passed in
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iDataEntryProductService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
