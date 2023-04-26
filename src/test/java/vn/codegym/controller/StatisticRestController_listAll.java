package vn.codegym.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StatisticRestController_listAll {
    @Autowired
    private MockMvc mockMvc;
    /**
     *This method is used to check the returned list is of size = 0
     * @throws Exception
     */
    @Test
    public void getListStatistics_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistic"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     *This method is used to check the returned list has size > 0
     * @throws Exception
     */
    @Test
    public void getListStatistics_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/statistics"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
