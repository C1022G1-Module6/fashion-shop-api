package vn.codegym.dto.employee;

import vn.codegym.entity.employee.Role;

import java.util.HashSet;
import java.util.Set;

public class EmployeeDetailDTO {
    private Integer id;
    private String code;
    private String name;
    private boolean gender;
    private String dateOfBirth;
    private String address;
    private String email;
    private String phoneNumber;
    private String userName;
    private String avatar;
    private Set<RoleDTO> roleDTOSetSet = new HashSet<>();
    public EmployeeDetailDTO() {
        // TODO document why this constructor is empty
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<RoleDTO> getRoleDTOSetSet() {
        return roleDTOSetSet;
    }

    public void setRoleDTOSetSet(Set<RoleDTO> roleDTOSetSet) {
        this.roleDTOSetSet = roleDTOSetSet;
    }
}