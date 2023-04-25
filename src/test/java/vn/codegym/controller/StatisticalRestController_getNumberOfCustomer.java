package vn.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StatisticalRestController_getNumberOfCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getNumberOfCustomer_id_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admins"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getNumberOfCustomer_id_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/studentRest/detail/{id}", "11"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(11))
                .andExpect(jsonPath("name").value("Trung"))
                .andExpect(jsonPath("dateOfBirth").value("2022-08-31"))
                .andExpect(jsonPath("classStudent.id").value(1));
    }
}
