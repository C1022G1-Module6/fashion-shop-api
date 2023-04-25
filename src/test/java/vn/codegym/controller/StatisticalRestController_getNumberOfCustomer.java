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

    /**
     * This function is used to check the display of the number of customer size = 0
     *
     * @author TruongTQ
     */

    @Test
    public void getNumberOfCustomer_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admins/customer/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to check the display of the number of customer size > 0
     *  id là số lượng khách hàng
     *  date là so sánh tháng này với tháng trước
     * @author TruongTQ
     */
    @Test
    public void getNumberOfCustomer_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/admins/customer"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())

                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].customer.id").value("3"))
                .andExpect(jsonPath("content[0].date").value("2"));

    }
}
