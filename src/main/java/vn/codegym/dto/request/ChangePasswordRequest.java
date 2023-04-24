package vn.codegym.dto.request;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangePasswordRequest {
    @NotBlank(message = "Không được bỏ trống")
    private String oldPassword;
    @NotBlank(message = "Không được bỏ trống")
    @Length(min = 5, max = 30, message = "Mật khẩu ít nhất 5 ký tự và nhiều nhất 30 ký tự")
    private String newPassword;
    @NotBlank(message = "Không được bỏ trống")
    private String confirmPassword;

    public ChangePasswordRequest() {
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}