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
public class ProductRestController_getAllProduct {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getAllProduct_5() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/products/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getAllProduct_6() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/products/page=2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(6))
                        .andExpect(jsonPath("totalElements").value(30))
                .andExpect(jsonPath("content[0].code").value("MH-01"))
                .andExpect(jsonPath("content[0].entryPrice").value(100))
                .andExpect(jsonPath("content[0].img").value("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png"))
                .andExpect(jsonPath("content[0].isDelete").value(0))
                .andExpect(jsonPath("content[0].name").value("Quần"))
                .andExpect(jsonPath("content[0].qrImg").value("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png"))
                .andExpect(jsonPath("content[0].quantity").value(25))
                .andExpect(jsonPath("content[0].sellingPrice").value(300))
                .andExpect(jsonPath("content[0].productTypeId").value(1))
                .andExpect(jsonPath("content[3].code").value("MH-06"))
                .andExpect(jsonPath("content[3].entryPrice").value(200))
                .andExpect(jsonPath("content[3].img").value("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png"))
                .andExpect(jsonPath("content[3].isDelete").value(0))
                .andExpect(jsonPath("content[3].name").value("Áo"))
                .andExpect(jsonPath("content[3].qrImg").value("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png"))
                .andExpect(jsonPath("content[3].quantity").value(30))
                .andExpect(jsonPath("content[3].sellingPrice").value(300))
                .andExpect(jsonPath("content[3].productTypeId").value(2));


    }
}
