package vn.codegym.dto.news;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.entity.employee.Employee;

public class NewsDTO implements Validator {
    private Integer id;
    private String title;
    private String img;
    private String nameImg;
    private Double mb;
    private String content;
    private String dateTime;
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

    public NewsDTO(Integer id, String title, String img, String nameImg, Double mb, String content, Employee employee) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.nameImg = nameImg;
        this.mb = mb;
        this.content = content;
        this.employee = employee;
    }

    public NewsDTO(String title, String img, String content, Employee employee) {
        this.title = title;
        this.img = img;
        this.content = content;
        this.employee = employee;
    }

    public NewsDTO(String title, String img, String nameImg, Double mb, String content, Employee employee) {
        this.title = title;
        this.img = img;
        this.nameImg = nameImg;
        this.mb = mb;
        this.content = content;
        this.employee = employee;
    }

    public double getMb() {
        return mb;
    }

    public void setMb(double mb) {
        this.mb = mb;
    }

    public String getNameImg() {
        return nameImg;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setNameImg(String nameImg) {
        this.nameImg = nameImg;
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
            errors.rejectValue("title", "title", "Nhập tiêu đề.");
        } else {
            int titleMinLength = newsDTO.getTitle().length();
            int titleMaxLength = newsDTO.getTitle().length();
            if (!(titleMinLength >= 10 && titleMaxLength <= 200)) {
                errors.rejectValue("title", "title", "Tiêu đề từ 10 đến 200 kí tự.");
            }
        }
        if (newsDTO.getNameImg().equals("")) {
            errors.rejectValue("nameImg", "nameImg", "Vui lòng chọn ảnh.");
        } else if (!(newsDTO.getNameImg().endsWith(".jpg") || newsDTO.getNameImg().endsWith(".png"))) {
            errors.rejectValue("nameImg", "nameImg", "Ảnh sai định dạng.");
        } else {
            if (newsDTO.getMb()>3){
                errors.rejectValue("nameImg", "nameImg", "Vui lòng chọn ảnh không quá 3 MB.");
            }
        }
        if (newsDTO.getContent().equals("")) {
            errors.rejectValue("content", "content", "Nhập nội dung.");
        } else {
            int minLengthContent = newsDTO.getContent().length();
            int maxLengthContent = newsDTO.getContent().length();
            if (!(minLengthContent >= 100 && maxLengthContent <= 5000)) {
                errors.rejectValue("content", "content", "Nội dung từ 100 đến 5000 kí tự.");
            }
        }




    }
}
