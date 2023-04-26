package vn.codegym.controller.employee;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.employee.EmployeeDetailDTO;
import vn.codegym.dto.response.ResponseMessage;
import vn.codegym.entity.employee.Employee;
import vn.codegym.security.JwtAuthenticationFilter;
import vn.codegym.security.JwtTokenProvider;
import vn.codegym.service.employee.IEmployeeService;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    /**
     * QuanNLA
     * Date 24/04/2023
     * Method that finds username and returns user information
     * @param request
     * @return
     * If checking the username does not match, it will return message "Tên người dùng không tồn tại"
     * If check username match, it will return EmployeeDTO object and HttpStatus.OK
     */
    @GetMapping("detail")
    public ResponseEntity<?> detail(HttpServletRequest request) {
            String token = jwtAuthenticationFilter.getJwt(request);
            if(token!=null &&jwtTokenProvider.validateToken(token)){
                String username = jwtTokenProvider.getUserNameFromToken(token);
                if(!iEmployeeService.existsByUsername(username)){
                    return new ResponseEntity<>(new ResponseMessage("Tên người dùng không tồn tại")
                            , HttpStatus.BAD_REQUEST);
                }
                EmployeeDetailDTO employeeDTO = new EmployeeDetailDTO();
                Optional<Employee> employee = iEmployeeService.findByUsername(username);
                BeanUtils.copyProperties(employee.get(),employeeDTO);
                return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
            }else {
                return new ResponseEntity<>(new ResponseMessage("JWT không tồn tại"),HttpStatus.BAD_REQUEST);
            }
    }
}
