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
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.dto.invoice.InvoiceDTO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class InvoiceRestController_updateInvoice {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this method is applied to test updateInvoice method in case of bonusPoint's value is null
     * @throws Exception
     * TuNT
     */
    @Test
    public void updateInvoice_bonusPoint_13 () throws Exception {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setCode("HD100001");
        invoiceDTO.setDate("2020-12-12");
        invoiceDTO.setBonusPoint(null);
        invoiceDTO.setPayment(10.0);
        invoiceDTO.setTotal(10.0);
        invoiceDTO.setEmployeeName("Nguyễn Văn A");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        invoiceDTO.setCustomerDTO(customerDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this method is applied to test updateInvoice method in case of bonusPoint's value is < 0
     * @throws Exception
     * TuNT
     */
    @Test
    public void updateInvoice_bonusPoint_15 () throws Exception {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setCode("HD100001");
        invoiceDTO.setDate("2020-12-12");
        invoiceDTO.setBonusPoint(-1);
        invoiceDTO.setPayment(10.0);
        invoiceDTO.setTotal(10.0);
        invoiceDTO.setEmployeeName("Nguyễn Văn A");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        invoiceDTO.setCustomerDTO(customerDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this method is applied to test updateInvoice method in case of total's value is null
     * @throws Exception
     * TuNT
     */
    @Test
    public void updateInvoice_total_13 () throws Exception {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setCode("HD100001");
        invoiceDTO.setDate("2020-12-12");
        invoiceDTO.setBonusPoint(10);
        invoiceDTO.setPayment(10.0);
        invoiceDTO.setTotal(null);
        invoiceDTO.setEmployeeName("Nguyễn Văn A");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        invoiceDTO.setCustomerDTO(customerDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this method is applied to test updateInvoice method in case of total's value is < 0
     * @throws Exception
     * TuNT
     */
    @Test
    public void updateInvoice_total_15 () throws Exception {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setCode("HD100001");
        invoiceDTO.setDate("2020-12-12");
        invoiceDTO.setBonusPoint(10);
        invoiceDTO.setPayment(10.0);
        invoiceDTO.setTotal(-10.0);
        invoiceDTO.setEmployeeName("Nguyễn Văn A");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        invoiceDTO.setCustomerDTO(customerDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this method is applied to test updateInvoice method in case of payment's value is null
     * @throws Exception
     * TuNT
     */
    @Test
    public void updateInvoice_payment_13 () throws Exception {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setCode("HD100001");
        invoiceDTO.setDate("2020-12-12");
        invoiceDTO.setBonusPoint(10);
        invoiceDTO.setPayment(null);
        invoiceDTO.setTotal(10.0);
        invoiceDTO.setEmployeeName("Nguyễn Văn A");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        invoiceDTO.setCustomerDTO(customerDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this method is applied to test updateInvoice method in case of payment's value is < 0
     * @throws Exception
     * TuNT
     */
    @Test
    public void updateInvoice_payment_15 () throws Exception {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setCode("HD100001");
        invoiceDTO.setDate("2020-12-12");
        invoiceDTO.setBonusPoint(10);
        invoiceDTO.setPayment(-10.0);
        invoiceDTO.setTotal(10.0);
        invoiceDTO.setEmployeeName("Nguyễn Văn A");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        invoiceDTO.setCustomerDTO(customerDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * this method is applied to test updateInvoice method in case of customerId's value is null
     * @throws Exception
     * TuNT
     */
    @Test
    public void updateInvoice_customerId_13 () throws Exception {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setCode("HD100001");
        invoiceDTO.setDate("2020-12-12");
        invoiceDTO.setBonusPoint(10);
        invoiceDTO.setPayment(10.0);
        invoiceDTO.setTotal(10.0);
        invoiceDTO.setEmployeeName("Nguyễn Văn A");
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(null);
        invoiceDTO.setCustomerDTO(customerDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/invoice")
                        .content(this.objectMapper.writeValueAsString(invoiceDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
