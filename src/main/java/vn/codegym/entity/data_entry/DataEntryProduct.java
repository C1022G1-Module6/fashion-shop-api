package vn.codegym.entity.data_entry;

import com.fasterxml.jackson.annotation.JsonBackReference;
import vn.codegym.entity.product.Product;

import javax.persistence.*;

@Entity
@Table(name = "data_entry_product")
public class DataEntryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "data_entry_id")
    @JsonBackReference
    private DataEntry dataEntry;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;
    private Boolean isDelete = false;
    private String size;
    private String productSizeCode;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProductSizeCode() {
        return productSizeCode;
    }

    public void setProductSizeCode(String productSizeCode) {
        this.productSizeCode = productSizeCode;
    }

    public DataEntry getDataEntry() {
        return dataEntry;
    }

    public void setDataEntry(DataEntry dataEntry) {
        this.dataEntry = dataEntry;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
