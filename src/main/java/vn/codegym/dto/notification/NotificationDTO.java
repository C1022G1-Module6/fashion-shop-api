package vn.codegym.dto.notification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import vn.codegym.dto.employee.EmployeeDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NotificationDTO {
    private Integer id;

    @NotBlank(message = "Vui lòng nhập tiêu đề thông báo")
    @Size(max = 30, message = "Tiêu đề không được vượt quá 30 ký tự")
    @Size(min = 6, message = "Tiêu đề tối thiểu là 6 ký tự")
    private String title;


    @NotBlank(message = "Vui lòng nhập nội dung thông báo")
    @Size(max = 1000, message = "Tiêu đề không được vượt quá 1000 ký tự")
    @Size(min = 20, message = "Nội dung tối thiểu là 20 ký tự")
    private String content;

    private String img;
    private String role;
    private Boolean isDelete = false;


    public NotificationDTO() {
    }

    public NotificationDTO(Integer id, String title, String content, String img, Boolean isDelete) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.img = img;

        this.isDelete = isDelete;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}

