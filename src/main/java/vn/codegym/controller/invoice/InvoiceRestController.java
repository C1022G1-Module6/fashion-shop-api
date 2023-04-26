package vn.codegym.controller.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.service.invoice.IInvoiceService;
import vn.codegym.service.invoice.impl.InvoiceDetailService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/invoice")
@CrossOrigin("*")
public class InvoiceRestController {
    @Autowired
    private IInvoiceService invoiceService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    /**
     * TuNT
     * this method is applied to send a List of invoice instances and a HttpStatus
     * @return
     */
    @GetMapping("")
    public ResponseEntity<?> getAllList() {
        try {
             List<InvoiceDTO> invoiceDTOList = invoiceService.findAll();
            return new ResponseEntity<>(invoiceDTOList ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * TuNT
     * this method is applied to update info of invoice instance with the param get from client and send HttpStatus
     * @param invoiceDTO
     * @return
     */
    @PutMapping("")
    public ResponseEntity<?> updateInvoice(@Validated @RequestBody InvoiceDTO invoiceDTO, BindingResult bindingResult) {
        if (invoiceDTO.getBonusPoint() == null || invoiceDTO.getTotal() == null
                || invoiceDTO.getPayment() == null || invoiceDTO.getCustomerDTO().getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!bindingResult.hasErrors()) {
            invoiceService.update(invoiceDTO);
            invoiceDetailService.resetCount();
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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getInvoice() {
        InvoiceDTO invoiceDTO = invoiceService.getInvoiceDetail();
        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
    }
}
