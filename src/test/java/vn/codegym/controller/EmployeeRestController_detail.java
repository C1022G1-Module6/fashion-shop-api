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
public class EmployeeRestController_detail {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void detail_username_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employee/detail?username={username}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    public void detail_username_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employee/detail?username={username}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void detail_username_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employee/detail?username={username}", "hello"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void detail_username_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/employee/detail?username={username}", "anhquan123"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("code").value("NV-0001"))
                .andExpect(jsonPath("name").value("Nguyễn Lê Anh Quân"))
                .andExpect(jsonPath("dateOfBirth").value("13/01/2000"))
                .andExpect(jsonPath("gender").value(false))
                .andExpect(jsonPath("userName").value("anhquan123"))
                .andExpect(jsonPath("phoneNumber").value("0901111111"))
                .andExpect(jsonPath("address").value("50 Hoàng Diệu"))
                .andExpect(jsonPath("email").value("nlaquan1301@gmail.com"));
    }
}
