package vn.codegym.dto.customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.entity.customer.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDTO implements Validator {
    private Integer id;

    private String code;

//    @NotBlank(message = "Tên không đươc để trống.")
//    @Pattern(regexp = "^[a-zA-ZÀ-ỹ\\s ]*$", message = "Tên không được nhập số và ký tự đặc biệt.")
    private String name;

    private boolean gender;

//    @NotBlank(message = "Ngày sinh không đươc để trống")
//    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])$",
//            message = "Ngày sinh phải đúng định dạng DD/MM/YYYY.")
    private String dateOfBirth;

//    @NotBlank(message = "Address cannot be left blank ")
//    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "Vui lòng nhập đúng địa chỉ")
    private String address;

//    @NotBlank(message = "Email không được để trống.")
//    @Pattern(message = "Email không đúng định dạng.", regexp = "[\\w]+[@][\\w]+.[\\w]+")
    private String email;

//    @NotBlank(message = "Số điện thoại không được để trống.")
//    @Pattern(message = "Số điện thoại không đúng định dạng.", regexp = "^(((\\\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})$")
    private String phoneNumber;

    private Integer point = 0;

    private Boolean isDelete = false;

    private CustomerTypeDTO customerTypeDTO;

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

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

//    public CustomerType getCustomerType() {
//        return customerType;
//    }
//
//    public void setCustomerType(CustomerType customerType) {
//        this.customerType = customerType;
//    }


    public CustomerTypeDTO getCustomerTypeDTO() {
        return customerTypeDTO;
    }

    public void setCustomerTypeDTO(CustomerTypeDTO customerTypeDTO) {
        this.customerTypeDTO = customerTypeDTO;
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
