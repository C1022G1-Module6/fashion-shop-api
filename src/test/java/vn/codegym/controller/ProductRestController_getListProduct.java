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
public class ProductRestController_getListProduct {
    @Autowired
    private MockMvc mockMvc;

    /**
     * TanTH
     * Created: 25/04/2023
     * Test for name null
     * Note: Function getListProduct set @RequestParam(name = "name", defaultValue = "") for param name
     * Expect:  HttpStatus.OK
     * Return: pages of product
     *
     * @throws Exception
     */
    @Test
    public void getListProduct_name_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/user/product/list?product_type_id=1&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * TanTH
     * Created: 25/04/2023
     * Test for name blank
     * Note: Function getListProduct set @RequestParam(name = "name", defaultValue = "") for param name
     * Expect:  HttpStatus.OK
     * Return: pages of product
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_name_8() throws Exception {
        String name = "";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/user/product/list?page=0&name=" + name))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * TanTH
     * Created: 25/04/2023
     * Test for name not exist in database
     * Note: Function getListProduct set @RequestParam(name = "name", defaultValue = "") for param name
     * Expect:  HttpStatus.OK
     * Return: pages of product
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_name_9() throws Exception {
        String notExistedName = "not existed name";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/user/product/list?page=0&name=" + notExistedName))
                .andDo(print())
                .andExpect(status().is(204));
    }

    /**
     * TanTH
     * Created: 25/04/2023
     * Test for name exists in database
     * Function: Test for name exists in database and return list with size > 0, can use for function getListProduct_name_10()
     * Note: Function getListProduct set @RequestParam(name = "name", defaultValue = "") for param name
     * Expect:  HttpStatus.No_Content
     * Return: pages of product
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_name_11() throws Exception {
        String existedName = "áo";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/user/product/list?page=0&name=" + existedName))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(4))
                .andExpect(jsonPath("content[0].id").value("1"))
                .andExpect(jsonPath("content[0].name").value("áo polo"))
                .andExpect(jsonPath("content[0].code").value("SP001"))
                .andExpect(jsonPath("content[0].sellingPrice").value(50000))
                .andExpect(jsonPath("content[0].quantity").value(50))
                .andExpect(jsonPath("content[0].entryPrice").value(50000))
                .andExpect(jsonPath("content[3].id").value("10"))
                .andExpect(jsonPath("content[3].name").value("áo polo"))
                .andExpect(jsonPath("content[3].code").value("SP001"))
                .andExpect(jsonPath("content[3].sellingPrice").value(50000))
                .andExpect(jsonPath("content[3].quantity").value(50))
                .andExpect(jsonPath("content[3].entryPrice").value(50000));
    }

    /**
     * TanTH
     * Created: 25/04/2023
     * Test for product_type_id null
     * Note: Function getListProduct set @RequestParam(product_type_id = "product_type_id", defaultValue = "") for param product_type_id
     * Expect:  HttpStatus.OK
     * Return: pages of product
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_product_type_id_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/user/product/list?name=ao&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * TanTH
     * Created: 25/04/2023
     * Test for product_type_id blank
     * Note: Function getListProduct set @RequestParam(product_type_id = "product_type_id", defaultValue = "") for param product_type_id
     * Expect:  HttpStatus.OK
     * Return: pages of product
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_product_type_id_8() throws Exception {
        String product_type_id = "";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/user/product/list?page=0&product_type_id=" + product_type_id))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * TanTH
     * Created: 25/04/2023
     * Test for product_type_id not exist in database
     * Note: Function getListProduct set @RequestParam(product_type_id = "product_type_id", defaultValue = "") for param product_type_id
     * Expect:  HttpStatus.OK
     * Return: pages of product
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_product_type_id_9() throws Exception {
        String notExistedProductTypeId = "not existed productTypeId";
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/user/product/list?page=0&product_type_id=" + notExistedProductTypeId))
                .andDo(print())
                .andExpect(status().is(400));
    }

    /**
     * TanTH
     * Created: 25/04/2023
     * Test for product_type_id exists in database
     * Function: Test for product_type_id exists in database and return list with size > 0, can use for function getListProduct_product_type_id_10()
     * Note: Function getListProduct set @RequestParam(product_type_id = "product_type_id", defaultValue = "") for param product_type_id
     * Expect:  HttpStatus.No_Content
     * Return: pages of product
     *
     * @throws Exception
     */

    @Test
    public void getListProduct_product_type_id_11() throws Exception {
        int existedProductTypeId = 2;
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/user/product/list?page=0&product_type_id=" + existedProductTypeId))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].id").value("2"))
                .andExpect(jsonPath("content[0].name").value("quần polo"))
                .andExpect(jsonPath("content[0].code").value("SP002"))
                .andExpect(jsonPath("content[0].sellingPrice").value(50000))
                .andExpect(jsonPath("content[0].quantity").value(40))
                .andExpect(jsonPath("content[0].entryPrice").value(30000))
                .andExpect(jsonPath("content[1].id").value("5"))
                .andExpect(jsonPath("content[1].name").value("quần polo"))
                .andExpect(jsonPath("content[1].code").value("SP002"))
                .andExpect(jsonPath("content[1].sellingPrice").value(50000))
                .andExpect(jsonPath("content[1].quantity").value(40))
                .andExpect(jsonPath("content[1].entryPrice").value(30000));
    }
}
