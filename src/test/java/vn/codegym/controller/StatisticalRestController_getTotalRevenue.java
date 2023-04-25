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
public class StatisticalRestController_getTotalRevenue {
    @Autowired
    private MockMvc mockMvc;
    /**
     * This function is used to check the display of total size > 0
     *
     * @author TruongTQ
     */
    @Test
    public void getInfoStudent_id_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admins/total/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to check the display of total size > 0
     *
     * @author TruongTQ
     */
    @Test
    public void getInfoStudent_id_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admins/total"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].payment").value("50000000"));

    }
}
