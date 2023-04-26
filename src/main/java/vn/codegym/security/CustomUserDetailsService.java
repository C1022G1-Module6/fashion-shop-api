package vn.codegym.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.codegym.entity.employee.Employee;
import vn.codegym.repository.employee.IEmployeeRepository;
import vn.codegym.service.employee.impl.EmployeeService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    /**
     * QuanNLA
     * DATE 24/04/2023
     * User authentication method
     * @param username the username identifying the user whose data is required.
     * @return the user's details (including username, password and role)
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = iEmployeeRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Không tìm thấy tên người dùng"+username));
        return UserPrinciple.build(employee);
    }

}