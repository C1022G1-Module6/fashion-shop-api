package vn.codegym.dto.employee;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public class EmployeeMailDTO {
    @NotBlank(message = "Không được để trống")
    @Email(message = "Vui lòng nhập đúng định dạng Email VD: abc123@codegym.com")
    private String email;
    private LocalDateTime expiryTime;
    private String otpSecret;
    private String code;

    public EmployeeMailDTO() {
        // TODO document why this constructor is empty
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getOtpSecret() {
        return otpSecret;
    }

    public void setOtpSecret(String otpSecret) {
        this.otpSecret = otpSecret;
    }
}
