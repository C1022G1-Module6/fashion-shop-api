package vn.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_productDetails {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void productDetails_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/detail?id={id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void productDetails_id_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/detail?id={id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void productDetails_id_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/detail?id={id}", 5))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void productDetails_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/detail?id={id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value("MH-01"))
                .andExpect(jsonPath("name").value("Quần"))
                .andExpect(jsonPath("quantity").value(5))
                .andExpect(jsonPath("size").value("S"))
                .andExpect(jsonPath("code").value("MH-01"))
                .andExpect(jsonPath("name").value("Quần"))
                .andExpect(jsonPath("quantity").value(5))
                .andExpect(jsonPath("size").value("M"));
        contentType(MediaType.APPLICATION_JSON);
    }
}

