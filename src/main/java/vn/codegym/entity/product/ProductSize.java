package vn.codegym.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_size")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "productSize")
    private Set<ProductSizeDetail> productSizeDetails;
    public ProductSize() {
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

    public Set<ProductSizeDetail> getProductSizeDetails() {
        return productSizeDetails;
    }

    public void setProductSizeDetails(Set<ProductSizeDetail> productSizeDetails) {
        this.productSizeDetails = productSizeDetails;
    }
}
