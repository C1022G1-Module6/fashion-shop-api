package vn.codegym.dto.news;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.entity.employee.Employee;

public class NewsDTO implements Validator {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        NewsDTO newsDTO = (NewsDTO) target;
        if (newsDTO.getTitle().equals("")) {
            errors.rejectValue("title", "title", "Nhập tiêu đề");
        } else {
            int titleMinLength = newsDTO.getTitle().length();
            int titleMaxLength = newsDTO.getTitle().length();
            if (!(titleMinLength >= 10 && titleMaxLength <=100)) {
                errors.rejectValue("title", "title", "Tiêu đề từ 10 đến 100 kí tự");
            }
        }
        if (newsDTO.getImg().matches("\\.(png|jpg|PNG|JPG)$")) {
            errors.rejectValue("img", "img", "Ảnh sai định dạng");
        }
        int minLengthContent = newsDTO.content.length();
        int maxLengthContent = newsDTO.content.length();
        if (!(minLengthContent >= 50 && maxLengthContent <= 500)) {
            errors.rejectValue("content", "content", "Nội dung từ 50 đến 500 kí tự");
        }
    }
}
