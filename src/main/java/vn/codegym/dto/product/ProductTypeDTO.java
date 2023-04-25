package vn.codegym.dto.product;

public class ProductTypeDTO {
    private Integer id;
    private String name;

    public ProductTypeDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}