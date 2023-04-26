package vn.codegym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.dto.data_entry.DataEntryProductDTO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DataEntryRestController_updatDataEntry {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this method is applied test the value of setEmployeeName is null
     * @throws Exception
     */
    @Test
    public void updateDataEntry_setEmployeeName_13 () throws Exception {
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(4);
        dataEntryDTO.setCode("MP111111");
        dataEntryDTO.setDate("2023-04-28");
        dataEntryDTO.setEmployeeName(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/data-entry")
                        .content(this.objectMapper.writeValueAsString(dataEntryDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this method is applied test the value of setCode is null
     * @throws Exception
     */
    @Test
    public void updateDataEntry_setCode_13 () throws Exception {
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(4);
        dataEntryDTO.setCode(null);
        dataEntryDTO.setDate("2023-04-28");
        dataEntryDTO.setEmployeeName("Thanh Phong");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/data-entry")
                        .content(this.objectMapper.writeValueAsString(dataEntryDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this method is applied test the value of setDate is null
     * @throws Exception
     */
    @Test
    public void updateDataEntry_setDate_13 () throws Exception {
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(4);
        dataEntryDTO.setCode("MP111111");
        dataEntryDTO.setDate(null);
        dataEntryDTO.setEmployeeName("Thanh Phong");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/data-entry")
                        .content(this.objectMapper.writeValueAsString(dataEntryDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is applicable to the case of setCode validation
     * @throws Exception
     */
    @Test
    public void updateDataEntry_setDate_15 () throws Exception {
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(4);
        dataEntryDTO.setCode("MP111");
        dataEntryDTO.setDate("2023-04-28");
        dataEntryDTO.setEmployeeName("Thanh Phong");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/data-entry")
                        .content(this.objectMapper.writeValueAsString(dataEntryDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is applied to the successful case
     * @throws Exception
     */
    @Test
    public void updateDataEntry_setDate_18 () throws Exception {
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(4);
        dataEntryDTO.setCode("MP111111");
        dataEntryDTO.setDate("2023-04-28");
        dataEntryDTO.setEmployeeName("Thanh Phong");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/data-entry")
                        .content(this.objectMapper.writeValueAsString(dataEntryDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
