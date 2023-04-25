package vn.codegym.dto.employee;

import vn.codegym.entity.employee.Role;
import vn.codegym.entity.news.News;
import vn.codegym.entity.notification.Notification;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class EmployeeDTO {
    private Integer id;
    private String code;
    private String name;
    private boolean gender;
    private String dateOfBirth;
    private String address;
    private String email;
    private String phoneNumber;
    private String userName;
    private String password;
//    private Set<Role> roles;
//    private Set<News> news;
//    private Set<Notification> notifications;
    private Boolean isDelete = false;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String code, String name, boolean gender, String dateOfBirth, String address, String email, String phoneNumber, String userName, String password, Set<Role> roles, Set<News> news, Set<Notification> notifications, Boolean isDelete) {

        this.id = id;
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.isDelete = isDelete;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    public Set<News> getNews() {
//        return news;
//    }
//
//    public void setNews(Set<News> news) {
//        this.news = news;
//    }
//
//    public Set<Notification> getNotifications() {
//        return notifications;
//    }
//
//    public void setNotifications(Set<Notification> notifications) {
//        this.notifications = notifications;
//    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
