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
import vn.codegym.dto.request.ChangePasswordRequest;
import vn.codegym.dto.request.SignInForm;
import vn.codegym.dto.response.JwtResponse;
import vn.codegym.dto.response.ResponseMessage;
import vn.codegym.entity.employee.Employee;
import vn.codegym.security.JwtTokenProvider;
import vn.codegym.security.UserPrinciple;
import vn.codegym.service.employee.IEmployeeService;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    /**
     * QuanNLA
     * Date 24/04/2023
     * Method used to log in
     * @param signInForm
     * @param bindingResult
     * @return
     * If you enter an incorrect validation error, it will return a bad_request error and include a list of errors
     * If check username does not exist then bad_request error and message "Tên người dùng không tồn tại" will be returned
     * If the authentication is successful, it will return a JWTResponse object including token, username, avatar, roles and HttpStatus.OK
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody SignInForm signInForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err){
                if(!map.containsKey(error.getField())){
                    map.put(error.getField(),error.getDefaultMessage());
                }
            }
            return  new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }else if(!iEmployeeService.existsByUsername(signInForm.getUsername())){
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
     * @param request
     * @param changePasswordRequest
     * @param bindingResult
     * @return
     * If you enter an incorrect validation error, it will return a bad_request error and include a list of errors
     * If token is null or not true it will return message "Mã JWT không chính xác"
     * If the old password does not match the current password, it will return message "Mật khẩu hiện tại không đúng"
     * If the new password does not match the old password, it will return message "Mật khẩu mới không được trùng với mật khẩu cũ"
     * If the confirmation password does not match the new password, it will return message "Mật khẩu xác nhận không trùng khớp"
     * If change password successful, it will return message "Đổi mật khẩu thành công!"
     */
    @PutMapping("/change-password")
    public ResponseEntity<?> changePassword(HttpServletRequest request, @Validated @RequestBody ChangePasswordRequest changePasswordRequest, BindingResult bindingResult){
        if(!bindingResult.hasErrors()) {
            final String requestTokenHeader = request.getHeader("Authorization");
            String username = null;
            String jwtToken = null;
            if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
                jwtToken = requestTokenHeader.substring(7);
                try {
                    username = jwtTokenProvider.getUserNameFromToken(jwtToken);
                } catch (IllegalArgumentException e) {
                    throw new JwtException("Không thể nhận được Mã thông báo JWT", e);
                } catch (ExpiredJwtException e) {
                    throw new JwtException("Mã thông báo JWT đã hết hạn", e);
                }
            } else {
                throw new JwtException("Mã JWT không chính xác");
            }
            Employee employee = iEmployeeService.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Tên người dùng không tồn tại"));
            if (!iEmployeeService.checkIfValidOldPassword(employee, changePasswordRequest.getOldPassword())) {
                return new ResponseEntity<>(new ResponseMessage("Mật khẩu hiện tại không đúng"), HttpStatus.BAD_REQUEST);
            }else if (changePasswordRequest.getNewPassword().equals(changePasswordRequest.getOldPassword())) {
                return new ResponseEntity<>(new ResponseMessage("Mật khẩu mới không được trùng với mật khẩu cũ"), HttpStatus.BAD_REQUEST);
            }else if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmPassword())) {
                return new ResponseEntity<>(new ResponseMessage("Mật khẩu xác nhận không trùng khớp"), HttpStatus.BAD_REQUEST);
            }else {
                iEmployeeService.changeUserPassword(employee, changePasswordRequest.getNewPassword());
                return ResponseEntity.ok(new ResponseMessage("Đổi mật khẩu thành công!"));
            }
        }else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
    }
}