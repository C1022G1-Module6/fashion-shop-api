package vn.codegym.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import vn.codegym.dto.news.NewsDTO;
import vn.codegym.entity.employee.Employee;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NewsRestController_createNews {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * This function is used to add 1 new news, Check the Title field for null
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_title_13() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle(null);
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/03/15/520589/lv-archlight-2.0-thumbnail-ngang-Cropped-445x250.png");
        newsDTO.setContent("Từ ngày 17/3, Louis Vuitton sẽ chính thức “thả xích” cho LV Archlight 2.0 – “người kế nhiệm” của siêu phẩm LV Archlight ra mắt vào năm 2018, hứa hẹn chiều lòng hội tín đồ sneakers Gen Z với những cải tiến đáng kể trong thiết kế.\n" +
                "\n" +
                "Năm 2018, Louis Vuitton từng khuấy đảo cộng đồng “đầu giày” khi cho ra mắt LV Archlight – một cuộc cách mạng giày thể thao đúng nghĩa. Với thiết kế avant-garde độc đáo cùng phần lưỡi cường điệu kích cỡ, đế cao su uốn lượn và kiểu dáng vị lai, dòng sneakers đã mang lại thành công thương mại và củng cố vị thế của thương hiệu suốt 5 năm. Trong tháng 3 này, đôi Archlight sẽ trở lại trong phiên bản 2.0, tiếp tục mở ra những nguồn cảm hứng mới thu hút hội tín đồ Gen Z thích khám phá và ưa trải nghiệm. ");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to add 1 new news, Check that the title field has a value of ""
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_title_14() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("");
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/03/15/520589/lv-archlight-2.0-thumbnail-ngang-Cropped-445x250.png");
        newsDTO.setContent("Năm 2018, Louis Vuitton từng khuấy đảo cộng  “đầu giày” khi cho ra mắt LV Archlight – một cuộc cách mạng giày thể thao đúng nghĩa. Với thiết kế avant-garde độc đáo cùng phần lưỡi cường điệu kích cỡ, đế cao su uốn lượn và kiểu dáng vị lai, dòng sneakers đã mang lại thành công thương mại và củng cố vị thế của thương hiệu suốt 5 năm. Trong tháng 3 này, đôi Archlight sẽ trở lại trong phiên bản 2.0, tiếp tục mở ra những nguồn cảm hứng mới thu hút hội tín đồ Gen Z thích khám phá và ưa trải nghiệm. ");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to add 1 new news, Check that the Title field has a value that is less than 10 characters
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_title_16() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("Áo");
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/03/15/520589/lv-archlight-2.0-thumbnail-ngang-Cropped-445x250.png");
        newsDTO.setContent("Năm 2018, Louis Vuitton từng khuấy đảo cộng  “đầu giày” khi cho ra mắt LV Archlight – một cuộc cách mạng giày thể thao đúng nghĩa. Với thiết kế avant-garde độc đáo cùng phần lưỡi cường điệu kích cỡ, đế cao su uốn lượn và kiểu dáng vị lai, dòng sneakers đã mang lại thành công thương mại và củng cố vị thế của thương hiệu suốt 5 năm. Trong tháng 3 này, đôi Archlight sẽ trở lại trong phiên bản 2.0, tiếp tục mở ra những nguồn cảm hứng mới thu hút hội tín đồ Gen Z thích khám phá và ưa trải nghiệm. ");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to add 1 new news, Check that the Title field has a value greater than 100 characters
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_title_17() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("Hình ảnh của chiến dịch lần này  dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưi cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4.");
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/03/15/520589/lv-archlight-2.0-thumbnail-ngang-Cropped-445x250.png");
        newsDTO.setContent("Từ ngày 17/3, Louis Vuitton sẽ chính thức “thả xích” cho LV Archlight 2.0 – “người kế nhiệm” của siêu phẩm LV Archlight ra mắt vào năm 2018, hứa hẹn chiều lòng hội tín đồ sneakers  Z với những cải tiến đáng kể trong thiết kế.\n");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to add 1 new news, Check the img field for null
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_img_13() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS");
        newsDTO.setImg(null);
        newsDTO.setContent("Từ ngày 17/3, Louis Vuitton sẽ chính thức “thả xích” cho LV Archlight 2.0 – “người kế nhiệm” của siêu phẩm LV Archlight ra mắt vào năm 2018, hứa hẹn chiều lòng hội tín đồ sneakers Gen Z với những cải tiến đáng kể trong thiết kế.\n" +
                "\n" +
                "Năm 2018, Louis Vuitton từng khuấy đảo cộng đồng “đầu giày” khi cho ra mắt LV Archlight – một cuộc cách mạng giày thể thao đúng nghĩa. Với thiết kế avant-garde độc đáo cùng phần lưỡi cường điệu kích cỡ, đế cao su uốn lượn và kiểu dáng vị lai, dòng sneakers đã mang lại thành công thương mại và củng cố vị thế của thương hiệu suốt 5 năm. Trong tháng 3 này, đôi Archlight sẽ trở lại trong phiên bản 2.0, tiếp tục mở ra những nguồn cảm hứng mới thu hút hội tín đồ Gen Z thích khám phá và ưa trải nghiệm. ");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to add 1 new news, Check the img field for ""
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_img_14() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS");
        newsDTO.setImg("");
        newsDTO.setContent("Từ ngày 17/3, Louis Vuitton sẽ chính thức “thả xích” cho LV Archlight 2.0 – “người kế nhiệm” của siêu phẩm LV Archlight ra mắt vào năm 2018, hứa hẹn chiều lòng hội tín đồ sneakers Gen Z với những cải tiến đáng kể trong thiết kế.\n" +
                "\n" +
                "Năm 2018, Louis Vuitton từng khuấy đảo cộng đồng “đầu giày” khi cho ra mắt LV Archlight – một cuộc cách mạng giày thể thao đúng nghĩa. Với thiết kế avant-garde độc đáo cùng phần lưỡi cường điệu kích cỡ, đế cao su uốn lượn và kiểu dáng vị lai, dòng sneakers đã mang lại thành công thương mại và củng cố vị thế của thương hiệu suốt 5 năm. Trong tháng 3 này, đôi Archlight sẽ trở lại trong phiên bản 2.0, tiếp tục mở ra những nguồn cảm hứng mới thu hút hội tín đồ Gen Z thích khám phá và ưa trải nghiệm. ");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to add 1 new news, Check format img field
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_img_15() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS");
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/04/12/524301/01-UNIQLO-Ket-Hop-Cung-JW-ANDERSON-Ra-Mat-BST-Dac-Biet-tu-30_03-in-dam-dau-an-phong-cach-co-dien-dac-trung-cua-cac-Truong-Dai-Hoc-Anh-Quoc.--445x250.xml");
        newsDTO.setContent("Từ ngày 17/3, Louis Vuitton sẽ chính thức “thả xích” cho LV Archlight 2.0 – “người kế nhiệm” của siêu phẩm LV Archlight ra mắt vào năm 2018, hứa hẹn chiều lòng hội tín đồ sneakers Gen Z với những cải tiến đáng kể trong thiết kế.\n" +
                "\n" +
                "Năm 2018, Louis Vuitton từng khuấy đảo cộng đồng “đầu giày” khi cho ra mắt LV Archlight – một cuộc cách mạng giày thể thao đúng nghĩa. Với thiết kế avant-garde độc đáo cùng phần lưỡi cường điệu kích cỡ, đế cao su uốn lượn và kiểu dáng vị lai, dòng sneakers đã mang lại thành công thương mại và củng cố vị thế của thương hiệu suốt 5 năm. Trong tháng 3 này, đôi Archlight sẽ trở lại trong phiên bản 2.0, tiếp tục mở ra những nguồn cảm hứng mới thu hút hội tín đồ Gen Z thích khám phá và ưa trải nghiệm. ");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to add 1 new news, Check format content value is null
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_content_13() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS");
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/04/12/524301/01-UNIQLO-Ket-Hop-Cung-JW-ANDERSON-Ra-Mat-BST-Dac-Biet-tu-30_03-in-dam-dau-an-phong-cach-co-dien-dac-trung-cua-cac-Truong-Dai-Hoc-Anh-Quoc.--445x250.jpg");
        newsDTO.setContent(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to add 1 new news, Check format content value is ""
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_content_14() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN”" );
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/04/12/524301/01-UNIQLO-Ket-Hop-Cung-JW-ANDERSON-Ra-Mat-BST-Dac-Biet-tu-30_03-in-dam-dau-an-phong-cach-co-dien-dac-trung-cua-cac-Truong-Dai-Hoc-Anh-Quoc.--445x250.jpg");
        newsDTO.setContent("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function is used to add 1 new news, Check format content length <50
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_content_16() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT ");
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/04/12/524301/01-UNIQLO-Ket-Hop-Cung-JW-ANDERSON-Ra-Mat-BST-Dac-Biet-tu-30_03-in-dam-dau-an-phong-cach-co-dien-dac-trung-cua-cac-Truong-Dai-Hoc-Anh-Quoc.--445x250.jpg");
        newsDTO.setContent("Áo mùa này rất đẹp");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function is used to add 1 new news, Check format content length >500
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_content_17() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN”");
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/04/12/524301/01-UNIQLO-Ket-Hop-Cung-JW-ANDERSON-Ra-Mat-BST-Dac-Biet-tu-30_03-in-dam-dau-an-phong-cach-co-dien-dac-trung-cua-cac-Truong-Dai-Hoc-Anh-Quoc.--445x250.jpg");
        newsDTO.setContent("Hình ảnh của chiến dịch lần các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. ");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * This function is used to add 1 new news, All [item] are valid
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void createNews_content_18() throws Exception {

        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setTitle("ANNE HATHAWAY HOÁ “THIÊN NGA ĐEN” TRONG BST MỚI NHẤT CỦA VERSACE – VERSACE ICONS");
        newsDTO.setImg("https://www.elle.vn/wp-content/uploads/2023/04/12/524301/01-UNIQLO-Ket-Hop-Cung-JW-ANDERSON-Ra-Mat-BST-Dac-Biet-tu-30_03-in-dam-dau-an-phong-cach-co-dien-dac-trung-cua-cac-Truong-Dai-Hoc-Anh-Quoc.--445x250.jpg");
        newsDTO.setContent("Hình ảnh của chiến dịch lần này  dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưi cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. Hình ảnh của chiến dịch lần này tập trung vào các biểu tượng về cách ăn mặc phi thường hàng ngày, được thể hiện bởi diễn viên Anne Hathaway và ca sĩ Chris Lee trong các bức chân dung của các nhiếp ảnh gia Mert và Marcus. Bộ sưu tập sẽ được ra mắt trên trang Versace.com và tại cửa hàng vào ngày 3 tháng 4. ");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/api-news/createNews")
                        .content(this.objectMapper.writeValueAsString(newsDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
