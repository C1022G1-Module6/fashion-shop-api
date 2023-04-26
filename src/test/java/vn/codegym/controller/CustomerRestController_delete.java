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
public class CustomerRestController_delete {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Test case delete customer with id parameter passed to null
     * @throws Exception
     */
    @Test
    public void delete_id_25() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/customer?id=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case delete customer with empty id parameter
     * @throws Exception
     */
    @Test
    public void delete_id_26() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/customer?id="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case delete customer with id parameter does not exist in database
     * @throws Exception
     */
    @Test
    public void delete_id_27() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/customer?id=999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Test case delete customer with id parameter exists in database
     * @throws Exception
     */
    @Test
    public void delete_id_28() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete("/api/customer/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
