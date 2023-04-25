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
public class NewsRestController_getNews {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function get a news of database, Check if the ID is null
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getInfoStudent_news_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api-news/detailNews?idNews=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function get a news of database, Check if the ID is ''
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getInfoStudent_news_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api-news/detailNews?idNews=''"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function get a news of database, Check if ID doesn't exist
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getInfoStudent_news_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api-news/detailNews?idNews=99999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function get a news of database, Successful retrieval a news
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getInfoStudent_news_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("http://localhost:8080/api-news/detailNews?idNews=17"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
