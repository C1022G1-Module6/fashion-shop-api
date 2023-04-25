package vn.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_search {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test case find customer code with null parameter
     *
     * @throws Exception
     */
    @Test
    public void search_code_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchCode=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case finds customer code with empty parameter
     *
     * @throws Exception
     */
    @Test
    public void search_code_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchCode="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Test case finds customer code whose parameter does not exist in the database
     *
     * @throws Exception
     */
    @Test
    public void search_code_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchCode=non-existing-code"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case find customer code whose parameter exists in database
     *
     * @throws Exception
     */
    @Test
    public void search_code_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchCode=KH-001"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Test case finding customer name with null parameter
     *
     * @throws Exception
     */
    @Test
    public void search_name_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchName=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case find customer name with empty parameter
     *
     * @throws Exception
     */
    @Test
    public void search_name_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchName="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Test case find customer name with parameter does not exist in database
     *
     * @throws Exception
     */
    @Test
    public void search_name_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchName=non-existing-name"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case find customer name with parameter exists in database
     * @throws Exception
     */
    @Test
    public void search_name_4() throws Exception {
        this.mockMvc.perform(
//                        MockMvcRequestBuilders.get("/api/customer?searchName=Trần%20Bá%20Tài"))
                        MockMvcRequestBuilders.get("/api/customer?searchName=Tài"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Test case find customer phone number with null parameter
     *
     * @throws Exception
     */
    @Test
    public void search_phone_number_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchPhoneNumber=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case find customer phone number with empty parameter
     *
     * @throws Exception
     */
    @Test
    public void search_phone_number_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchPhoneNumber="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * Test case find customer phone number with parameter does not exist in database
     *
     * @throws Exception
     */
    @Test
    public void search_phone_number_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchPhoneNumber=non-existing-code"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case find customer phone number with parameter exists in database
     *
     * @throws Exception
     */
    @Test
    public void search_phone_number_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer?searchPhoneNumber=0961487519"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This method is used to search for customers by information such as code,
     * name or phone number and returns a customer page with the page size and page number
     * specified by the paginable parameter.
     * @throws Exception
     */
    @Test
    public void search_with_pageable() throws Exception {
        int pageSize = 3;
        int pageNumber = 0;
        String sortBy = "id";
        Sort sort = Sort.by(sortBy);
        PageRequest pageable = PageRequest.of(pageNumber, pageSize, sort);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/customer")
                                .param("searchCode", "")
                                .param("searchName", "")
                                .param("searchPhoneNumber", "")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .param("page", String.valueOf(pageNumber))
                                .param("size", String.valueOf(pageSize))
                                .param("sort", sortBy)
                ).andDo(print())
                .andExpect(status().isOk());
    }
}
