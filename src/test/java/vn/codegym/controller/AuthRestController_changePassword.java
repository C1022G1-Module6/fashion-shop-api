package vn.codegym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.dto.request.ChangePasswordRequest;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthRestController_changePassword {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_VALUE = "eyJhbGciOiJIUzUxMiJ9." +
            "eyJzdWIiOiJ0aGFuaHBob25nMTIzIiwiaWF0IjoxNjgyNDAxOTkyLCJleHAiOjE2ODI0ODgzOTJ9." +
            "VsNmDUcDpogi5GQbxPv4burTrWO01apSVngyUrArzsTuQssiOtwLas8XLGZjsaw-QLCngYLtKxjvza_92cOVDA";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void changePassword_oldPassWord_19() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword(null);
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_oldPassWord_20() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * In case the password does not exist under the database
     *
     * @throws Exception
     */
    @Test
    public void changePassword_oldPassWord_99() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc11111");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_oldPassWord_22() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("a");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_oldPassWord_23() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abcaabcabcabababbcabbabacbabacbacbabacbcababcab");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_newPassWord_19() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword(null);
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_newPassWord_20() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * In case the new password is the same as the old password
     *
     * @throws Exception
     */
    @Test
    public void changePassword_newPassWord_99() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("abc123");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_newPassWord_22() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("a");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_newPassWord_23() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("abcaabcabcabababbcabbabacbabacbacbabacbcababcab");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_confirmPassWord_19() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_confirmPassWord_20() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * In case the confirm password does not match the new password
     *
     * @throws Exception
     */
    @Test
    public void changePassword_confirmPassWord_99() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("abc12345555");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_confirmPassWord_22() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("a");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_confirmPassWord_23() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("abcaabcabcabababbcabbabacbabacbacbabacbcababcab");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void changePassword_confirmPassWord_24() throws Exception {
        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setOldPassword("abc123");
        changePasswordRequest.setNewPassword("abc12345");
        changePasswordRequest.setConfirmPassword("abc12345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/change-password")
                        .header(AUTHORIZATION_HEADER, "Bearer " + TOKEN_VALUE)
                        .content(this.objectMapper.writeValueAsString(changePasswordRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
