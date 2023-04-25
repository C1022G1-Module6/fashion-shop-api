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
public class CustomerRestController_createCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to test the validation of field name more specific is null
     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_name_13() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field code more specific is null
     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_code_13() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field address more specific is null
     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_address_13() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field email more specific is null
     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_email_13() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field date of birth more specific is null
     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_dateOfBirth_13() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    /**
//     * this function use to test the validation of field gender more specific is null
//     *
//     * @author TienTHM
//     * @Time 14h00 25/04/2023
//     */
//    @Test
//    public void createCustomer_name_13() throws Exception {
//        CustomerDTO customerDTO = new CustomerDTO();
//        customerDTO.setCode("KH-001");
//        customerDTO.setName("Tran Minh Tien");
//        customerDTO.setAddress("Ha Tinh");
//        customerDTO.setEmail("tranminhtien@gmail.com");
//        customerDTO.setDateOfBirth("2001-10-04");
//        customerDTO.setGender(true);
//        customerDTO.setPhoneNumber("0231568947");
//        customerDTO.setPoint(10);
//        CustomerType customerType = new CustomerType();
//        customerType.setId(2);
//        customerDTO.setCustomerType(customerType);
//
//        this.mockMvc.perform(MockMvcRequestBuilders
//                        .post("api/customer/create")
//                        .content(this.objectMapper.writeValueAsString(customerDTO))
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//    }

    /**
     * this function use to test the validation of field phone number more specific is null
     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_phoneNumber_13() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field point more specific is null
     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_point_13() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test the validation of field name more specific is empty     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_name_14() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field code more specific is empty     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_code_14() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field address more specific is empty     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_address_14() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field name more specific is empty     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_email_14() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field date of birth more specific is empty     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_dateOfBirth_14() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field phone number more specific is empty     *
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_phoneNumber_14() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field name more specific is containing special character
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_name_15() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field code more specific is containing special character
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_code_15() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field address more specific is containing special character
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_address_15() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field email more specific is containing special character
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_email_15() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field date of birth more specific is containing special character
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_dateOfBirth_15() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test the validation of field phone number more specific is containing special character
     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_phoneNumber_15() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *  this function use to test the validation of field name more specific is min length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_name_16() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field code more specific is min length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_code_16() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field adress more specific is min length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_address_16() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field email more specific is min length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_email_16() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field date of birth more specific is min length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_dateOfBirth_16() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field phone number more specific is min length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_phoneNumber_16() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     *  this function use to test the validation of field email more specific is max length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_name_17() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field email more specific is max length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_code_17() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field address more specific is max length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_address_17() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field email more specific is max length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_email_17() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field date of birth more specific is max length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_dateOfBirth_17() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *  this function use to test the validation of field phone number more specific is max length

     * @author TienTHM
     * @Time 14h00 25/04/2023
     */
    @Test
    public void createCustomer_phoneNumber_17() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to create customer with all valid item
     *
     * @author TienTHM
     * @Time 14:00 25/04/2023
     */
    @Test
    public void createCustomer_18() throws Exception {
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
                        .post("api/customer/create")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
