package vn.codegym.service.mail.impl;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import vn.codegym.entity.employee.Employee;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.mail.IEmailService;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

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
            message.setText( "<html>" +
                    "<body>" +
                    "<div style=\" font-size:15px;\">"+
                    "Kính gửi Quý khách hàng," + "<br>" + "<br>" +
                            "<div style =\" font-weight:bold \"> Đây là mã OTP của bạn: [" + otp +"] </div>" + "<br>" +
                            "Mã OTP này sẽ hết hạn trong vòng 1 phút kể từ khi bạn nhận được email này. " +
                            "Vui lòng không chia sẻ mã này với bất kỳ ai, " +
                            "vì nó được sử dụng để xác thực tài khoản của bạn." +
                            "<br>" +
                            "Nếu bạn không yêu cầu mã OTP, " +
                            "vui lòng bỏ qua email này hoặc liên hệ với chúng tôi để được hỗ trợ."
                            + "<br>"
                            + "<br>"
                            + "Trân trọng," +
                    "<div style =\"color:#183661; font-size:20px ; font-weight:bold\">Fashion Shop</div>" +
                    "</div>" +
                    "</body>" +
                    "</html>", true);
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
        LocalDateTime expiryTime = employee.getExpiryTime();
        if (expiryTime != null && LocalDateTime.now().isAfter(expiryTime)) {
            System.out.println("Mã OTP đã hết hạn");
            return false;
        }
        String secret = employee.getOtpSecret();
        boolean isValid = gAuth.authorize(secret, code);
        if (Boolean.TRUE.equals(isValid)) {
            employee.setOtpSecret(null);
            employee.setExpiryTime(null);
            iEmployeeService.updateOtp(employee);
        }else {
            System.out.println("Mã OTP không chính xác");
        }
        return isValid;
    }

    @Override
    public String generateOtp(Employee employee) {
        GoogleAuthenticatorConfig config = new GoogleAuthenticatorConfig
                .GoogleAuthenticatorConfigBuilder()
                .setCodeDigits(6)
                .build();
        GoogleAuthenticator gAuth = new GoogleAuthenticator(config);
        GoogleAuthenticatorKey key = gAuth.createCredentials();
        String secret = key.getKey();
        employee.setExpiryTime(LocalDateTime.now().plusMinutes(1));
        employee.setOtpSecret(secret);
        iEmployeeService.updateOtp(employee);
        int code = gAuth.getTotpPassword(secret);
        return Integer.toString(code);
    }
}