package vn.codegym.dto.customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerDTO implements Validator {
    private Integer id;
    private String code;
    private String name;
    private boolean gender;
    private String dateOfBirth;
    private String address;
    private String email;
    private String phoneNumber;
    private Integer point = 0;
    private CustomerTypeDTO customerTypeDTO;
    private Boolean isDelete = false;

    public CustomerDTO() {
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

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public CustomerTypeDTO getCustomerTypeDTO() {
        return customerTypeDTO;
    }

    public void setCustomerTypeDTO(CustomerTypeDTO customerTypeDTO) {
        this.customerTypeDTO = customerTypeDTO;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
    }
}
