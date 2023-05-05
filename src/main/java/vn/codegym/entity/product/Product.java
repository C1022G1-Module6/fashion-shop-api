package vn.codegym.entity.product;

import vn.codegym.entity.data_entry.DataEntryProduct;
import vn.codegym.entity.invoice.InvoiceDetail;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private Integer quantity;
    private String qrImg;
    private String img;
    private Double sellingPrice;
    private Double entryPrice;
    private boolean isDelete = false;
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    @JsonBackReference
    private ProductType productType;
    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private Set<ProductSizeDetail>  productSizeDetails;
    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private Set<DataEntryProduct> dataEntryProductSet;

    public Set<DataEntryProduct> getDataEntryProductSet() {
        return dataEntryProductSet;
    }

    public void setDataEntryProductSet(Set<DataEntryProduct> dataEntryProductSet) {
        this.dataEntryProductSet = dataEntryProductSet;
    }

    public Product() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getQrImg() {
        return qrImg;
    }

    public void setQrImg(String qrImg) {
        this.qrImg = qrImg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(Double entryPrice) {
        this.entryPrice = entryPrice;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<ProductSizeDetail> getProductSizeDetails() {
        return productSizeDetails;
    }

    public void setProductSizeDetails(Set<ProductSizeDetail> productSizeDetails) {
        this.productSizeDetails = productSizeDetails;
    }
    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
