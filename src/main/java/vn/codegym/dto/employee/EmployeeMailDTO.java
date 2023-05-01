package vn.codegym.dto.employee;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class EmployeeMailDTO {
    @NotBlank(message = "Không được để trống")
    @Email(message = "Vui lòng nhập đúng định dạng Email VD: abc123@codegym.com")
    private String email;

    public EmployeeMailDTO() {
        // TODO document why this constructor is empty
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
