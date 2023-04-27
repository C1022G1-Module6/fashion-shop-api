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
public class productRestController_searchProducts {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void searchProducts_name_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/search?name like {name}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchProducts_name_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/search?name like {name}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchProducts_name_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/search?name like {name}", "QuanTVA"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void searchProducts_name_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/search?name like {name}", "Quần jean"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value("MH-04"))
                .andExpect(jsonPath("name").value("Quần jean"))
                .andExpect(jsonPath("entryPrice").value(200))
                .andExpect(jsonPath("img").value("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png"))
                .andExpect(jsonPath("isDelete").value(0))
                .andExpect(jsonPath("name").value("Quần jean"))
                .andExpect(jsonPath("qrImg").value("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png"))
                .andExpect(jsonPath("quantity").value(15))
                .andExpect(jsonPath("sellingPrice").value(350))
                .andExpect(jsonPath("productTypeId").value(2));
        contentType(MediaType.APPLICATION_JSON);
    }
    @Test
    public void searchProducts_productTypeId_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/search?productTypeId like {productTypeId}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void searchProducts_productTypeId_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/search?productTypeId like {productTypeId}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void searchProducts_productTypeId_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/search?productTypeId like {productTypeId}", "QuanTVA"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void searchProducts_productTypeId_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/search?productTypeId like {productTypeId}", "Áo"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("code").value("MH-02"))
                .andExpect(jsonPath("entryPrice").value(200))
                .andExpect(jsonPath("img").value("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png"))
                .andExpect(jsonPath("isDelete").value(0))
                .andExpect(jsonPath("name").value("Áo"))
                .andExpect(jsonPath("qrImg").value("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png"))
                .andExpect(jsonPath("quantity").value(30))
                .andExpect(jsonPath("sellingPrice").value(300))
                .andExpect(jsonPath("productTypeId").value(2));
        contentType(MediaType.APPLICATION_JSON);
    }
}
