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
public class ProductTypeRestController_findAllProductType {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAllProductType_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/product-type/"))
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
                .andExpect(jsonPath("content[0].name").value("Áo"))
                .andExpect(jsonPath("content[1].id").value(2))
                .andExpect(jsonPath("content[1].name").value("Quần"));
    }
}
