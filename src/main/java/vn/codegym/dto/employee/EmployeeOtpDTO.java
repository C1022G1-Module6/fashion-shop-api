package vn.codegym.dto.employee;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class EmployeeOtpDTO {
    private String email;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^\\d{5,6}$",message = "Vui lòng nhập đúng định dạng OTP VD:XXXXXX (X là chữ số)")
    private String code;

    public EmployeeOtpDTO() {
        // TODO document why this constructor is empty
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
