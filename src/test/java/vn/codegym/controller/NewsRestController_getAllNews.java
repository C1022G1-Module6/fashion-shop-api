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
public class NewsRestController_getAllNews {
    @Autowired
    private MockMvc mockMvc;

    /**
     * This function use to test list news of field search is "null", page = 0
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getAllNews_7() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api-news/listNews?page=0&tittleSearch=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list news of field search is "", page = 0
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getAllNews_8() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api-news/listNews?page=0&tittleSearch="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    /**
     * This function use to test list news of field search is "abcdef", page = 0
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getAllNews_9() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api-news/listNews?page=0&tittleSearch=abcdef"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list news of field search is "@@@@@", page = 0
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getAllNews_9_1() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api-news/listNews?page=0&tittleSearch=@@@@@"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list news of field search is "Xu hướng áo suit với quần short bermuda thanh lịch khi tới công sở", page = 0
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getAllNews_10() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api-news/listNews?page=0&tittleSearch=Xu hướng áo suit với quần short bermuda thanh lịch khi tới công sở"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test list news of field search is "Q", page = 0
     *
     * @Author: TanNN
     * @Date: 25/04/2023
     */
    @Test
    public void getAllNews_11() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/api-news/listNews?page=0&tittleSearch=Q"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].title").value("JIMIN (BTS) ĐỒNG HÀNH CÙNG ZOË KRAVITZ VÀ GAL GADOT TRONG CHIẾN DỊCH QUẢNG CÁO “THIS IS TIFFANY”"))
                .andExpect(jsonPath("content[0].content").value("<p><a href=\"https://www.elle.vn/tin-thoi-trang/trang-suc-tiffany-co-grammy-2023\">Tiffany &amp; Co</a>. ch&iacute;nh thức h&eacute; lộ chiến dịch quảng c&aacute;o mới nhất d&agrave;nh cho bộ sưu tập Tiffany T v&agrave; Tiffany HardWear với sự tham gia của c&aacute;c đại sứ thương hiệu gồm nữ diễn vi&ecirc;n, ca sĩ v&agrave; người mẫu Zo&euml; Kravitz, ca sĩ&nbsp;<a href=\"https://www.elle.vn/tin-thoi-trang/jimin-bts-dai-su-thuong-hieu-tiffany-co\">Jimin</a>&nbsp;của nh&oacute;m nhạc BTS &ndash; biểu tượng của nhạc pop thế kỷ 21 v&agrave; nữ diễn vi&ecirc;n&nbsp;<a href=\"https://www.elle.vn/bi-quyet-cua-sao/gal-gadot-hoang-hau-disney\">Gal Gadot</a>. Chiến dịch quảng c&aacute;o lần n&agrave;y l&agrave; sự chắt lọc những gi&aacute; trị cốt l&otilde;i mang t&iacute;nh biểu tượng khi nhắc đến Tiffany &amp; Co.. Ch&acirc;n thực, đầy t&iacute;nh biểu cảm v&agrave; cũng rất thực tế, &ldquo;This is Tiffany&rdquo; l&agrave; lời khẳng định c&aacute;i t&ocirc;i của từng c&aacute; nh&acirc;n. Sự lạc quan, niềm y&ecirc;u th&iacute;ch th&iacute;ch v&agrave; c&aacute; t&iacute;nh mạnh mẽ to&aacute;t l&ecirc;n khi mỗi người chọn đeo trang sức Tiffany theo c&aacute;ch ri&ecirc;ng của m&igrave;nh.&nbsp;</p>\n"))
                .andExpect(jsonPath("content[0].img").value("https://firebasestorage.googleapis.com/v0/b/uploadfirebase-408b4.appspot.com/o/HW_Jimin_L4_VK_1282_v3_R600_v3_QC_R600_FOGRA_150dpi.jpg?alt=media&token=3db71fec-a28c-48f9-a031-3a9af5344f51"))
                .andExpect(jsonPath("content[1].title").value("QUỲNH ANH SHYN VÀ ANH TÚ DIỆN THIẾT KẾ KENZO, KHOE PHONG CÁCH CÙNG DÀN SAO CHÂU Á"))
                .andExpect(jsonPath("content[1].content").value("<p>Bảo t&agrave;ng ArtScience ở&nbsp;<a href=\"https://www.elle.vn/du-lich/dia-diem-du-lich-singapore\">Singapore</a>&nbsp;&ndash; t&ograve;a nh&agrave; độc đ&aacute;o mang kiến tr&uacute;c h&igrave;nh b&ocirc;ng sen lưu trữ h&agrave;ng trăm t&aacute;c phẩm nghệ thuật nổi tiếng &ndash; được ấn định l&agrave; nơi ra mắt BST &ldquo;KENZO Varsity Jungle&rdquo; Xu&acirc;n-H&egrave; 2023. Kh&ocirc;ng kh&iacute; tươi vui, t&aacute;o bạo bao tr&ugrave;m buổi tr&igrave;nh diễn, ch&agrave;o đ&oacute;n những t&iacute;n đồ thời trang h&agrave;ng đầu Ch&acirc;u &Aacute;.</p>\n"))
                .andExpect(jsonPath("content[1].img").value("https://firebasestorage.googleapis.com/v0/b/uploadfirebase-408b4.appspot.com/o/KYAT0832.jpg?alt=media&token=7fac520d-d3bd-41ad-a48e-0a97c191ec87"))
   ;
    }
}
