package vn.codegym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.dto.request.SignInForm;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthRestController_login {
    @Autowired
    private MockMvc mockMvc;
    @Autowired

    private ObjectMapper objectMapper;

    @Test
    public void login_username_13() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername(null);
        signInForm.setPassword("abc123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_username_14() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("");
        signInForm.setPassword("abc123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_username_15() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("abc12345");
        signInForm.setPassword("abc123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_username_16() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("a");
        signInForm.setPassword("abc123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_username_17() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("abcabcabcabcabcabcabcabcabcabcabcabcabbcabcabcabcabcabcabcabcabcabcaababababc");
        signInForm.setPassword("abc123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_13() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("anhquan123");
        signInForm.setPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_14() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("anhquan123");
        signInForm.setPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_15() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("anhquan123");
        signInForm.setPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_16() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("anhquan123");
        signInForm.setPassword("a");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_password_17() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("anhquan123");
        signInForm.setPassword("abcabcabcabcabcabcabcabcabcabcabcabcabbcabcabcabcabcabcabcabcabcabcaababababc");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void login_18() throws Exception {
        SignInForm signInForm = new SignInForm();
        signInForm.setUsername("anhquan123");
        signInForm.setPassword("abc123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/login")
                        .content(this.objectMapper.writeValueAsString(signInForm))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}