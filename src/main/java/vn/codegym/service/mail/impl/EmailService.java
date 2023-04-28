package vn.codegym.service.mail.impl;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import vn.codegym.entity.employee.Employee;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.mail.IEmailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private IEmployeeService iEmployeeService;
    public void sendResetPasswordEmail(String email, String otp) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper message = null;
        try {
            message = new MimeMessageHelper(mimeMessage, true);
            message.setTo(email);
            message.setSubject("Xác Thực Mã OTP");
            message.setText(
                    "Chào bạn," + "\n" +
                            "Đây là mã OTP của bạn: [ " + otp +" ]" + "\n" +
                            "Mã OTP này sẽ hết hạn trong vòng 1 phút kể từ khi bạn nhận được email này. " +
                            "Vui lòng không chia sẻ mã này với bất kỳ ai, " +
                            "vì nó được sử dụng để xác thực tài khoản của bạn." +
                            "\n" +
                            "Nếu bạn không yêu cầu mã OTP này, vui lòng bỏ qua email này hoặc liên hệ với chúng tôi để được hỗ trợ."
                            + "\n"
                            + "Trân trọng," + "\n" + "Fashion Shop"

            );
            javaMailSender.send(message.getMimeMessage());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean validateOtp(String otpCode, String email) {
        Employee employee = iEmployeeService.findByEmailEmployee(email);
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        int code = Integer.parseInt(otpCode);
        String secret = employee.getOtpSecret();
        boolean isValid = gAuth.authorize(secret, code);
        if (isValid) {
            employee.setOtpSecret(null);
            employee.setExpiryTime(null);
            iEmployeeService.updateOtp(employee);
        }
        return isValid;
    }

    @Override
    public String generateOtp(Employee employee) {
        GoogleAuthenticator gAuth = new GoogleAuthenticator();
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        String secret = key.getKey();
        employee.setOtpSecret(secret);
        employee.setExpiryTime(LocalDateTime.now().plusMinutes(1));
        iEmployeeService.updateOtp(employee);
        int code = gAuth.getTotpPassword(secret);
        return Integer.toString(code);
    }

}