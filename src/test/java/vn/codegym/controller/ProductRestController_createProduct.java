package vn.codegym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.dto.product.ProductCreateDTO;
import vn.codegym.dto.product.ProductSizeDTO;
import vn.codegym.dto.product.ProductTypeDTO;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestController_createProduct {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * created by QuanTVA
     * [code] ""
     * @throws Exception
     */
    @Test
    public void createProduct_code_14() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("");
        productCreateDTO.setName("Áo tay lỡ ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [code] = null
     *
     */
    @Test
    public void createProduct_code_13() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("null");
        productCreateDTO.setName("Áo");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [code] wrong format code: MH-XX (XX is number 0-9999)
     * @throws Exception
     */
    public void createProduct_code_15() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("08");
        productCreateDTO.setName("Áo tay lỡ ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     *[code] max length
     * @throws Exception
     */
    @Test
    public void createProduct_code_16() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-100000000");
        productCreateDTO.setName("Áo tay lỡ ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Test [code] success
     * @throws Exception
     */
    @Test
    public void createProduct_code_18() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo tay lỡ ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }


    /**
     * [name] = null
     *
     */
    @Test
    public void createProduct_name_13() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Quần hawail");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [code] wrong format name : no input number
     * @throws Exception
     */
    @Test
    public void createProduct_name_15() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("123456");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     *[name] max length
     * @throws Exception
     */
    @Test
    public void createProduct_name_16() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("A ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [name] = ""
     * @throws Exception
     */
    @Test
    public void createProduct_name_14() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName(" ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [name] test success
     * @throws Exception
     */
    @Test
    public void createProduct_name_18() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo dài ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * [qrImg] null
     * @throws Exception
     */

    @Test
    public void createProduct_qrImg_13() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Quần hawail");
        productCreateDTO.setQrImg("null");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [qrImg] wrong format
     * @throws Exception
     */
    @Test
    public void createProduct_qrImg_15() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo Ấm");
        productCreateDTO.setQrImg("https://product.hstatic.net////123123///1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     *[code] wrong format
     * @throws Exception
     */
    @Test
    public void createProduct_qrImg_16() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Áo ấm ");
        productCreateDTO.setQrImg("https://product.hst///abc//atic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [qrImg] null
     * @throws Exception
     */
    @Test
    public void createProduct_qrImg_14() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Áo ấm");
        productCreateDTO.setQrImg("");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [qrImg] test success
     * @throws Exception
     */
    @Test
    public void createProduct_qrImg_18() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo dài ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * [img] = ""
     * @throws Exception
     */
    @Test
    public void createProduct_img_13() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Quần hawail");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [img] wrong format
     * @throws Exception
     */
    @Test
    public void createProduct_Img_15() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo Ấm");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/123123123123/1///31/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     *[img] wrong format
     * @throws Exception
     */

    @Test
    public void createProduct_img_16() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Áo ấm ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product./asdasd//hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [img] = null
     * @throws Exception
     */
    @Test
    public void createProduct_img_14() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Áo ấm");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("null");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [img] test success
     * @throws Exception
     */
    @Test
    public void createProduct_img_18() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo dài ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * [entryPrice] = 0.0
     * @throws Exception
     */
    @Test
    public void createProduct_entryPrice_13() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Quần hawail");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(0.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [entryPrice] max length
     * @throws Exception
     */
    @Test
    public void createProduct_entryPrice_15() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo Ấm");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(100000000.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     *[code] min length
     * @throws Exception
     */
    @Test
    public void createProduct_entryPrice_16() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Áo ấm ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(1.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [entryPrice] = null
     * @throws Exception
     */
    @Test
    public void createProduct_entryPrice_14() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Áo ấm");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(null);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [entryPrice] test success
     * @throws Exception
     */
    @Test
    public void createProduct_entryPrice_18() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo dài ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    /**
     * [sellingPrice] = 0.0
     * @throws Exception
     */
    @Test
    public void createProduct_sellingPrice_13() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Quần hawail");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(0.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [sellingPrice] max length
     * @throws Exception
     */
    @Test
    public void createProduct_sellingPrice_15() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-08");
        productCreateDTO.setName("Áo Ấm");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(100.0);
        productCreateDTO.setSellingPrice(2500000000000000.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     *[sellingPrice] min length (sellingPrice and entryPrice 100.000-5.000.000)
     * @throws Exception
     */
    @Test
    public void createProduct_sellingPrice_16() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Áo ấm ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(120.0);
        productCreateDTO.setSellingPrice(2.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * [sellingPrice] null
     * @throws Exception
     */
    @Test
    public void createProduct_sellingPrice_14() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-09");
        productCreateDTO.setName("Áo ấm");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(150.0);
        productCreateDTO.setSellingPrice(null);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * test success
     * @throws Exception
     */
    @Test
    public void createProduct_sellingPrice_18() throws Exception {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setCode("MH-12");
        productCreateDTO.setName("Áo dài ");
        productCreateDTO.setQrImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setImg("https://product.hstatic.net/1000351433/product/outdoor_everyday_shorts_den_1f5b637cd613437ea4602475403ea3d5_master.png");
        productCreateDTO.setEntryPrice(123.0);
        productCreateDTO.setSellingPrice(250.0);
        ProductTypeDTO productType = new ProductTypeDTO();
        productCreateDTO.setProductType(productType);
        Set<ProductSizeDTO> productSizes = new HashSet<>();
        productCreateDTO.setProductSizes(productSizes);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/create-product")
                        .content(this.objectMapper.writeValueAsString(productCreateDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

}