package vn.codegym.controller.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.service.invoice.IInvoiceService;
import vn.codegym.service.invoice.impl.InvoiceDetailService;

@RestController
@RequestMapping("/invoice")
@CrossOrigin("*")
public class InvoiceRestController {
    @Autowired
    private IInvoiceService invoiceService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @PutMapping("")
    public ResponseEntity<?> updateInvoice(@RequestBody InvoiceDTO invoiceDTO) {
        try {
            invoiceService.update(invoiceDTO);
            invoiceDetailService.resetCount();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
