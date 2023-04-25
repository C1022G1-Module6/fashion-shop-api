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
public class ProductSizeRestController_findAllProductSize {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllProductSize_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product-size/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void findAllProductSize_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product-size"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].id").value(1))
                .andExpect(jsonPath("content[0].name").value("S"))
                .andExpect(jsonPath("content[1].id").value(2))
                .andExpect(jsonPath("content[1].name").value("M"))
                .andExpect(jsonPath("content[2].id").value(3))
                .andExpect(jsonPath("content[2].name").value("L"))
                .andExpect(jsonPath("content[3].id").value(4))
                .andExpect(jsonPath("content[3].name").value("XL"))
                .andExpect(jsonPath("content[4].id").value(5))
                .andExpect(jsonPath("content[4].name").value("XXL"));

    }
}
