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
import vn.codegym.dto.product.ProductDTO;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DataEntryProductRestController_createDataEntryProduct {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this method is applied test the value of quantity is null
     * @throws Exception
     */
    @Test
    public void createDataEntryProduct_quantity_13() throws Exception{
    DataEntryProductDTO dataEntryProductDTO = new DataEntryProductDTO();
    dataEntryProductDTO.setQuantity(null);
    DataEntryDTO dataEntryDTO = new DataEntryDTO();
    dataEntryDTO.setId(1);
    dataEntryProductDTO.setDataEntryDTO(dataEntryDTO);
    ProductDTO productDTO = new ProductDTO();
    productDTO.setCode("789");
    dataEntryProductDTO.setProductDTO(productDTO);
    dataEntryProductDTO.setDelete(false);
    this.mockMvc
            .perform(MockMvcRequestBuilders.post("/data-entry-product")
                    .content(this.objectMapper.writeValueAsString(dataEntryProductDTO))
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andDo(print())
            .andExpect(status().is4xxClientError());
}
    /**
     * this method is applied test the value of data_entry_id is null
     * @throws Exception
     */
    @Test
    public void createDataEntryProduct_dataEntry_13() throws Exception{
        DataEntryProductDTO dataEntryProductDTO = new DataEntryProductDTO();
        dataEntryProductDTO.setQuantity(10);
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(null);
        dataEntryProductDTO.setDataEntryDTO(dataEntryDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("789");
        dataEntryProductDTO.setProductDTO(productDTO);
        dataEntryProductDTO.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/data-entry-product")
                        .content(this.objectMapper.writeValueAsString(dataEntryProductDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this method is applied test the value of product_id is null
     * @throws Exception
     */
    @Test
    public void createDataEntryProduct_product_13() throws Exception{
        DataEntryProductDTO dataEntryProductDTO = new DataEntryProductDTO();
        dataEntryProductDTO.setQuantity(10);
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(1);
        dataEntryProductDTO.setDataEntryDTO(dataEntryDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode(null);
        dataEntryProductDTO.setProductDTO(productDTO);
        dataEntryProductDTO.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/data-entry-product")
                        .content(this.objectMapper.writeValueAsString(dataEntryProductDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is applicable to the case of quantity validation
     * @throws Exception
     */
    @Test
    public void createDataEntryProduct_quantity_15() throws Exception{
        DataEntryProductDTO dataEntryProductDTO = new DataEntryProductDTO();
        dataEntryProductDTO.setQuantity(-1);
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(1);
        dataEntryProductDTO.setDataEntryDTO(dataEntryDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("789");
        dataEntryProductDTO.setProductDTO(productDTO);
        dataEntryProductDTO.setDelete(false);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/data-entry-product")
                        .content(this.objectMapper.writeValueAsString(dataEntryProductDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This method is applied to the successful case
     * @throws Exception
     */
    @Test
    public void createDataEntryProduct_18() throws Exception{
        DataEntryProductDTO dataEntryProductDTO = new DataEntryProductDTO();
        dataEntryProductDTO.setQuantity(10);
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(1);
        dataEntryProductDTO.setDataEntryDTO(dataEntryDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("789");
        dataEntryProductDTO.setProductDTO(productDTO);
        dataEntryProductDTO.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/data-entry-product")
                        .content(this.objectMapper.writeValueAsString(dataEntryProductDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createDataEntryProduct_14() throws Exception{
        DataEntryProductDTO dataEntryProductDTO = new DataEntryProductDTO();
        dataEntryProductDTO.setQuantity(10);
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        dataEntryDTO.setId(1);
        dataEntryProductDTO.setDataEntryDTO(dataEntryDTO);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("");
        dataEntryProductDTO.setProductDTO(productDTO);
        dataEntryProductDTO.setDelete(false);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/data-entry-product")
                        .content(this.objectMapper.writeValueAsString(dataEntryProductDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
