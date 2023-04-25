package vn.codegym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.entity.customer.CustomerType;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_editCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to test the validation of field name more specific is null
     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_name_19() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName(null);
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field code more specific is null
     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_code_19() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode(null);
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field address more specific is null
     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_address_19() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress(null);
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field email more specific is null
     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_email_19() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail(null);
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field date of birth more specific is null
     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_dateOfBirth_19() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth(null);
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * this function use to test the validation of field phone number more specific is null
     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_phoneNumber_19() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber(null);
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field point more specific is null
     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_point_19() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(null);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field name more specific is empty     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_name_20() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field code more specific is empty     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_code_20() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field address more specific is empty     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_address_20() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field name more specific is empty     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_email_20() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field date of birth more specific is empty     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_dateOfBirth_20() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0231568947");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field phone number more specific is empty     *
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_phoneNumber_20() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field name more specific is containing special character
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_name_21() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien@#");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field code more specific is containing special character
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_code_21() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001@#$");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field address more specific is containing special character
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_address_21() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh@##$");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field email more specific is containing special character
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_email_21() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com#$%");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field date of birth more specific is containing special character
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_dateOfBirth_21() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04#$%");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field phone number more specific is containing special character
     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_phoneNumber_21() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561@#$");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *  this function use to test the validation of field name more specific is min length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_name_22() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tra");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field code more specific is min length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_code_22() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("K");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field adress more specific is min length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_address_22() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561@#$");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field email more specific is min length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_email_22() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tra");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field date of birth more specific is min length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_dateOfBirth_22() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("200");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field phone number more specific is min length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_phoneNumber_22() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("081");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *  this function use to test the validation of field email more specific is max length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_name_23() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tiennnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field email more specific is max length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_code_23() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-0011111111111111111111111111111111111111111111111");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field address more specific is max length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_address_23() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field email more specific is max length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_email_23() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.commmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field date of birth more specific is max length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_dateOfBirth_23() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-0444444444444444444444444444444444444444444444444444444444");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field phone number more specific is max length

     * @author TienTHM
     * @Time 15h00 25/04/2023
     */
    @Test
    public void editCustomer_phoneNumber_23() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("08378795611111111111111111111111111111111111111111111111111111");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to create customer with all valid item
     *
     * @author TienTHM
     * @Time 15:00 25/04/2023
     */
    @Test
    public void editCustomer_24() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCode("KH-001");
        customerDTO.setName("Tran Minh Tien");
        customerDTO.setAddress("Ha Tinh");
        customerDTO.setEmail("tranminhtien@gmail.com");
        customerDTO.setDateOfBirth("2001-10-04");
        customerDTO.setGender(true);
        customerDTO.setPhoneNumber("0837879561");
        customerDTO.setPoint(10);
        CustomerType customerType = new CustomerType();
        customerType.setId(2);
        customerDTO.setCustomerType(customerType);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("api/customer/edit")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}

