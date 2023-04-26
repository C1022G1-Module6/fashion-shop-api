package vn.codegym.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.dto.invoice.InvoiceDetailDTO;
import vn.codegym.dto.product.ProductDTO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceDetailRestController_createInvoiceDetail {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this method is applied test the value of quantity is null
     * @throws Exception
     * TuNT
     */
    @Test
    public void createInvoiceDetail_quantity_13() throws Exception {
        InvoiceDetailDTO invoiceDetailDTO = new InvoiceDetailDTO();
        invoiceDetailDTO.setQuantity(null);
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(1);
        invoiceDetailDTO.setInvoiceDTO(invoiceDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(2);
        invoiceDetailDTO.setProductDTO(productDTO);
        invoiceDetailDTO.setTotal(3.0);
        invoiceDetailDTO.setDelete(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/invoice-detail")
                        .content(this.objectMapper.writeValueAsString(invoiceDetailDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this method is applied test the value of quantity is not an integer
     * @throws Exception
     * TuNT
     */
    @Test
    public void createInvoiceDetail_quantity_15() throws Exception {
        InvoiceDetailDTO invoiceDetailDTO = new InvoiceDetailDTO();
        invoiceDetailDTO.setQuantity(-1);
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(1);
        invoiceDetailDTO.setInvoiceDTO(invoiceDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(2);
        invoiceDetailDTO.setProductDTO(productDTO);
        invoiceDetailDTO.setTotal(3.0);
        invoiceDetailDTO.setDelete(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/invoice-detail")
                        .content(this.objectMapper.writeValueAsString(invoiceDetailDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this method is applied test the value of productDTO 's id is null
     * @throws Exception
     * TuNT
     */
    @Test
    public void createInvoiceDetail_productDTOId_13() throws Exception {
        InvoiceDetailDTO invoiceDetailDTO = new InvoiceDetailDTO();
        invoiceDetailDTO.setQuantity(2);
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(1);
        invoiceDetailDTO.setInvoiceDTO(invoiceDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(null);
        invoiceDetailDTO.setProductDTO(productDTO);
        invoiceDetailDTO.setTotal(3.0);
        invoiceDetailDTO.setDelete(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/invoice-detail")
                        .content(this.objectMapper.writeValueAsString(invoiceDetailDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
