package vn.codegym.dto.employee;
import vn.codegym.entity.employee.Employee;
import vn.codegym.entity.employee.RoleName;

import java.util.HashSet;
import java.util.Set;

public class RoleDTO {
    private Integer id;

    private RoleName name;
    Set<EmployeeDetailDTO> employeeDetailDTOS = new HashSet<>();
    public RoleDTO() {
    }

    public Set<EmployeeDetailDTO> getEmployeeDetailDTOS() {
        return employeeDetailDTOS;
    }

    public void setEmployeeDetailDTOS(Set<EmployeeDetailDTO> employeeDetailDTOS) {
        this.employeeDetailDTOS = employeeDetailDTOS;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
