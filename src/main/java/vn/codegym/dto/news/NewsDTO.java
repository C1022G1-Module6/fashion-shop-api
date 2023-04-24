package vn.codegym.dto.news;


import vn.codegym.entity.employee.Employee;

public class NewsDTO {
    private Integer id;
    private String title;
    private String img;
    private String content;
    private Employee employee;

    public NewsDTO() {
    }

    public NewsDTO(Integer id, String title, String img, String content, Employee employee) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.content = content;
        this.employee = employee;
    }

    public NewsDTO(String title, String img, String content, Employee employee) {
        this.title = title;
        this.img = img;
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

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
