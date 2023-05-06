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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public ResponseEntity<List<InvoiceDTO>> getAllList() {
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
        if (invoiceDTO.getTotal() == null ||invoiceDTO.getPayment() == null || invoiceDTO.getCustomerDTO().getCode() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (invoiceDTO.getCustomerDTO().getCode().equals("")) {
            return new ResponseEntity<>("Không được bỏ trống",HttpStatus.BAD_REQUEST);
        }
        if (!bindingResult.hasErrors()) {
            String msg = invoiceService.update(invoiceDTO);
            if (!Objects.equals(msg, "")) {
                return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
            }
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
    public ResponseEntity<InvoiceDTO> getInvoice() {
        InvoiceDTO invoiceDTO = invoiceService.getInvoiceDetail();
        SimpleDateFormat initialDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = invoiceDTO.getDate();
        String dateInNewFormat = "";
        try {
            Date newDate = initialDateFormat.parse(date);
            dateInNewFormat = newDateFormat.format(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        invoiceDTO.setDate(dateInNewFormat);
        return new ResponseEntity<>(invoiceDTO, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Void> cancelInvoice () {
        invoiceDetailService.resetCount();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
