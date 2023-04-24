package vn.codegym.dto.request;

import javax.validation.constraints.NotBlank;

public class ChangePasswordRequest {
    @NotBlank(message = "Không được bỏ trống")
    private String oldPassword;
    @NotBlank(message = "Không được bỏ trống")
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