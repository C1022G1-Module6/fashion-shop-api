package vn.codegym.entity.news;

import com.fasterxml.jackson.annotation.JsonBackReference;
import vn.codegym.entity.employee.Employee;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String img;
    private String nameImg; //TanNN thêm vào
    private String content;
    private String dateTime; //TanNN thêm vào
    private double mb;
    private boolean flagDelete;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private Employee employee;

    public News() {
    }

    public News(String title, String img, String nameImg,double mb ,String content, Employee employee) {
        this.title = title;
        this.img = img;
        this.nameImg = nameImg;
        this.mb = mb;
        this.content = content;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Employee getEmployee() {
        return employee;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getNameImg() {
        return nameImg;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
    }

    public String getDateTime() {
        return dateTime;
    }

    public double getMb() {
        return mb;
    }

    public void setMb(double mb) {
        this.mb = mb;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
