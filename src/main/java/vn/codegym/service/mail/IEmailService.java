package vn.codegym.service.mail;
import vn.codegym.entity.employee.Employee;
public interface IEmailService {
    void sendResetPasswordEmail(String email, String otp);
    boolean validateOtp(String otpCode, String email);
    String generateOtp(Employee employee);

}
