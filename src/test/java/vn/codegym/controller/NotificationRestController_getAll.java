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
public class NotificationRestController_getAll {
    @Autowired
    private  MockMvc mockMvc;

    @Test
    public void getAll_5() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/notifications"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void getAll_6() throws Exception {
            this.mockMvc.perform(
                    MockMvcRequestBuilders
                            .get("/notifications/"))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful())
                    .andExpect(jsonPath("totalPages").value(2))
                    .andExpect(jsonPath("totalElements").value(3))
                    .andExpect(jsonPath("content[0].title").value("Nghỉ lễ"))
                    .andExpect(jsonPath("content[0].content").value("Nghỉ lễ"))
                    .andExpect(jsonPath("content[0].img").value("src/img/nghiLe.png"))
                    .andExpect(jsonPath("content[0].employee.id").value(1));

    }

}
