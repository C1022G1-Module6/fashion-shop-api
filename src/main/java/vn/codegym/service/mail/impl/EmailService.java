package vn.codegym.service.mail.impl;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import vn.codegym.entity.employee.Employee;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.mail.IEmailService;

import java.time.LocalDateTime;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private IEmployeeService iEmployeeService;
    public void sendResetPasswordEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setCc(email);
        message.setSubject("Reset Password");
        message.setText("Your OTP is " + otp);
        javaMailSender.send(message);
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