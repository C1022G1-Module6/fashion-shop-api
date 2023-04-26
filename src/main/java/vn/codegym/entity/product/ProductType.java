package vn.codegym.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "productType")
    @JsonBackReference
    private Set<Product> products;

    public ProductType(Integer id) {
        this.id = id;
    }

    public ProductType() {

    }


    public static ProductType valueOf(Integer productTypeId) {
        return null
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

    public static ProductType valueOf(Integer productTypeId) {
        return null;


    }
}

