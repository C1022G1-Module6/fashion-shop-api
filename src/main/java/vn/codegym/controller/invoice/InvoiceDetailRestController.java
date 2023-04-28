package vn.codegym.controller.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.invoice.InvoiceDetailDTO;
import vn.codegym.service.invoice.IInvoiceDetailService;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invoice-detail")
@CrossOrigin("*")
public class InvoiceDetailRestController {
    @Autowired
    private IInvoiceDetailService invoiceDetailService;

    @PostMapping("")
    public ResponseEntity<?> createInvoiceDetail(@Valid @RequestBody InvoiceDetailDTO invoiceDetailDTO, BindingResult bindingResult) {
        if (invoiceDetailDTO.getProductDTO().getCode() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!bindingResult.hasErrors()) {
            invoiceDetailService.save(invoiceDetailDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map,  HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<InvoiceDetailDTO>> listAll() {
        List<InvoiceDetailDTO> invoiceDetailDTOList = invoiceDetailService.findAll();
        return new ResponseEntity<>(invoiceDetailDTOList ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        invoiceDetailService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
