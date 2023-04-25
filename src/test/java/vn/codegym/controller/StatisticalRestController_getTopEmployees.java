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
public class StatisticalRestController_getTopEmployees {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function is used to check the display of the top employees size = 0
     *
     * @author TruongTQ
     */

    @Test
    public void getTopEmployees_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admins/top-selling/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to check the display of top employees size > 0
     *
     * @author TruongTQ
     */
    @Test
    public void getTopEmployees_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admins/top-selling"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].name").value("truong"))
                .andExpect(jsonPath("content[0].phoneNumber").value("098761231"))
                .andExpect(jsonPath("content[0].dateOfBirth").value("20/06/2000"))
                .andExpect(jsonPath("content[4].name").value("vinh"))
                .andExpect(jsonPath("content[4].phoneNumber").value("076528171"))
                .andExpect(jsonPath("content[4].dateOfBirth").value("20/06/1999"));

    }
}
