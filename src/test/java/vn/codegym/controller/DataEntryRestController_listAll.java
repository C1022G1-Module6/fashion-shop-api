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
public class DataEntryRestController_listAll {
    @Autowired
    private MockMvc mockMvc;

    /**
     *This method is used to check the returned list is of size 0
     * @throws Exception
     */
    @Test
    public void getListDataEntryProduct_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/data-entry-product"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *This method is used to check the returned list has size > 0
     * @throws Exception
     */
    @Test
    public void getListDataEntryProduct_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/data-entry"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].code").value("123"))
                .andExpect(jsonPath("content[0].date").value("2023/04/25"))
                .andExpect(jsonPath("content[0].employeeName").value("Hà Nguyễn Thanh Phong"))
                .andExpect(jsonPath("content[0].dataEntryProductDTOSet").value(null))
                .andExpect(jsonPath("content[3].code").value("126"))
                .andExpect(jsonPath("content[3].date").value("2023/04/28"))
                .andExpect(jsonPath("content[3].employeeName").value("Nguyễn Lê Anh Quân"))
                .andExpect(jsonPath("content[3].dataEntryProductDTOSet").value(null));
    }
}
