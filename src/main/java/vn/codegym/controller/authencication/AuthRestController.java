package vn.codegym.controller.authencication;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.employee.EmployeeMailDTO;
import vn.codegym.dto.employee.EmployeeOtpDTO;
import vn.codegym.dto.request.ChangePasswordRequest;
import vn.codegym.dto.request.ResetPasswordRequest;
import vn.codegym.dto.request.SignInForm;
import vn.codegym.dto.response.JwtResponse;
import vn.codegym.dto.response.ResponseMessage;
import vn.codegym.entity.employee.Employee;
import vn.codegym.security.JwtTokenProvider;
import vn.codegym.security.UserPrinciple;
import vn.codegym.service.employee.IEmployeeService;
import vn.codegym.service.mail.IEmailService;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class AuthRestController {

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private IEmailService iEmailService;

    /**
     * QuanNLA
     * Date 24/04/2023
     * Method used to log in
     *
     * @param signInForm
     * @param bindingResult
     * @return If you enter an incorrect validation error, it will return a bad_request error and include a list of errors
     * If check username does not exist then bad_request error and message "Tên người dùng không tồn tại" will be returned
     * If the authentication is successful, it will return a JWTResponse object including token, username, avatar, roles and HttpStatus.OK
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody SignInForm signInForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        } else if (Boolean.FALSE.equals(iEmployeeService.existsByUsername(signInForm.getUsername()))) {
            return new ResponseEntity<>(new ResponseMessage("Tên người dùng không tồn tại"), HttpStatus.BAD_REQUEST);
        } else {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.createToken(authentication);
            UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
            return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAvatar(), userPrinciple.getAuthorities()));
        }
    }

    /**
     * QuanNLA
     * Date 24/04/2023
     * Method used to change password
     *
     * @param request
     * @param changePasswordRequest
     * @param bindingResult
     * @return If you enter an incorrect validation error, it will return a bad_request error and include a list of errors
     * If token is null or not true it will return message "Mã JWT không chính xác"
     * If the old password does not match the current password, it will return message "Mật khẩu hiện tại không đúng"
     * If the new password does not match the old password, it will return message "Mật khẩu mới không được trùng với mật khẩu cũ"
     * If the confirmation password does not match the new password, it will return message "Mật khẩu xác nhận không trùng khớp"
     * If change password successful, it will return message "Đổi mật khẩu thành công!"
     */
    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(HttpServletRequest request, @Validated @RequestBody ChangePasswordRequest changePasswordRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        final String requestTokenHeader = request.getHeader("Authorization");
        String username;
        String jwtToken;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtTokenProvider.getUserNameFromToken(jwtToken);
            } catch (ExpiredJwtException e) {
                throw new JwtException("Mã thông báo JWT đã hết hạn", e);
            }
        } else {
            return new ResponseEntity<>(new ResponseMessage("Mã JWT không chính xác"), HttpStatus.BAD_REQUEST);
        }
        Employee employee = iEmployeeService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Tên người dùng không tồn tại"));
        if (Boolean.FALSE.equals(iEmployeeService.checkIfValidOldPassword(employee, changePasswordRequest.getOldPassword()))) {
            return new ResponseEntity<>(new ResponseMessage("Mật khẩu hiện tại không đúng"), HttpStatus.BAD_REQUEST);
        }
        if (changePasswordRequest.getNewPassword().equals(changePasswordRequest.getOldPassword())) {
            return new ResponseEntity<>(new ResponseMessage("Mật khẩu mới không được trùng với mật khẩu cũ"), HttpStatus.BAD_REQUEST);
        }
        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmPassword())) {
            return new ResponseEntity<>(new ResponseMessage("Mật khẩu xác nhận không trùng khớp"), HttpStatus.BAD_REQUEST);
        }
        iEmployeeService.changeUserPassword(employee, changePasswordRequest.getNewPassword());
        return ResponseEntity.ok(new ResponseMessage("Đổi mật khẩu thành công!"));
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@Validated @RequestBody ResetPasswordRequest resetPasswordRequest, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Employee employee = iEmployeeService.findByEmailEmployee(resetPasswordRequest.getEmail());
            if(employee != null){
                if (!resetPasswordRequest.getNewPassword().equals(resetPasswordRequest.getConfirmPassword())) {
                    return new ResponseEntity<>(new ResponseMessage("Mật khẩu xác nhận không trùng khớp"), HttpStatus.BAD_REQUEST);
                } else {
                    iEmployeeService.changeUserPassword(employee, resetPasswordRequest.getNewPassword());
                    return ResponseEntity.ok(new ResponseMessage("Đổi mật khẩu thành công!"));
                }
            }else {
                return new ResponseEntity<>(new ResponseMessage("Không tìm thấy email"), HttpStatus.BAD_REQUEST);
            }
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> processForgotPassword(@Validated @RequestBody EmployeeMailDTO employeeMailDTO,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        Employee employee = iEmployeeService.findByEmailEmployee(employeeMailDTO.getEmail());
        if (employee == null) {
            return new ResponseEntity<>(new ResponseMessage("Không tìm thấy email"), HttpStatus.BAD_REQUEST);
        }
        String otp = iEmailService.generateOtp(employee);
        iEmailService.sendResetPasswordEmail(employeeMailDTO.getEmail(), otp);
        return new ResponseEntity<>(employeeMailDTO.getEmail(), HttpStatus.OK);
    }

    @PutMapping("/check-otp")
    public ResponseEntity<?> confirmForgotPassword(@Validated @RequestBody EmployeeOtpDTO employeeOtpDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        if (iEmailService.validateOtp(employeeOtpDTO.getCode(), employeeOtpDTO.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Xác thực mã OTP thành công"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseMessage("Mã OTP không chính xác"), HttpStatus.BAD_REQUEST);
        }
    }
}