package vn.codegym.controller.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.invoice.InvoiceDetailDTO;
import vn.codegym.service.invoice.IInvoiceDetailService;

import java.util.List;

@RestController
@RequestMapping("/invoice-detail")
@CrossOrigin("*")
public class InvoiceDetailRestController {
    @Autowired
    private IInvoiceDetailService invoiceDetailService;

    @PostMapping("")
    public ResponseEntity<?> createInvoiceDetail(@RequestBody InvoiceDetailDTO invoiceDetailDTO) {
//        try {
        invoiceDetailService.save(invoiceDetailDTO);
        return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
    }

    @GetMapping("")
    public ResponseEntity<?> listAll() {
        try {
            List<InvoiceDetailDTO> invoiceDetailDTOList = invoiceDetailService.findAll();
            return new ResponseEntity<>(invoiceDetailDTOList ,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
