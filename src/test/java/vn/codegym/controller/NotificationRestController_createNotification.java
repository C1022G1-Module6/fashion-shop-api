package vn.codegym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import vn.codegym.dto.employee.EmployeeDTO;
import vn.codegym.dto.notification.NotificationDTO;
import vn.codegym.entity.employee.Employee;



@SpringBootTest
@AutoConfigureMockMvc
public class NotificationRestController_createNotification {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createNotification_title_13() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle(null);
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createNotification_title_14() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createNotification_title_15() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());


    }

    @Test
    public void createNotification_title_16() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("H");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());


    }

    @Test
    public void createNotification_title_17() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("VinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas" +
                "VinhOdasVinhOdasVinhOdasVinhOdasinhOdas");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());


    }


    @Test
    public void createNotification_content_13() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent(null);
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createNotification_content_14() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createNotification_content_15() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());


    }

    @Test
    public void createNotification_content_16() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("V");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());


    }

    @Test
    public void createNotification_content_17() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("VinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas" +
                "VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdasinhOdasVVinhOdasVinhOdasVinhOdasVinhOdasVinhOdas\" +\n" +
                "                \"VinhOdasVinhOdasVinhOdasVinhOdasinhOdas");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());


    }


    @Test
    public void createNotification_img_13() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg(null);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createNotification_img_14() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createNotification_img_15() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isNotAcceptable());


    }




    @Test
    public void createNotification_employee_id_13() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(null);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createNotification_18() throws Exception{
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setTitle("Vắng phép");
        notificationDTO.setContent("Vắng phép");
        notificationDTO.setImg("src/img/donXinPhep.png");
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(1);
        notificationDTO.setEmployeeDTO(employeeDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/notifications/create")
                        .content(this.objectMapper.writeValueAsString(notificationDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }





}
