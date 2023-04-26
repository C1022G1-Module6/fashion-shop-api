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
public class NewsRestController_getRelateNews {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function get list Relate News, not paging and not search
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getRelateNews_4() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api-news/relatedNews"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
