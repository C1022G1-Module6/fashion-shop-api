package vn.codegym.dto.product;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class ProductCreateDTO {
    @NotBlank(message = "Không được để trống")
    @Size(max = 800,message = "Không được vượt quá 800 ký tự")
    @Pattern(regexp = "^MH-(\\d{1,3})$", message = "Theo định dạng MH-XXX trong đó XXX từ 0-999")

    private String code;
@NotBlank(message = "Không được để trống")
@Size(max = 800,message = "Không được vượt quá 800 ký tự" )
@Pattern(regexp = "^[A-Z][a-zđàáảãạăắằẵặẳâầấậẫẩêềếểệễéèẻẹëẽíìỉịĩóòỏõọôổốộỗồơờớợỡởùúủụũưừứựữửỳỷỹỵ\\s]*$",message = "Chữ đầu tiên viết hoa và mấy chữ sau có thể viết dấu" +
        "ví dụ như Áo ấm, Quần dài")
    private String name;
@NotBlank(message = "Không được để trống")
    private String qrImg;
@NotBlank(message = "Không được để trống")
    private String img;
@NotBlank(message = "Không được để trống")
@Pattern(regexp = "^(?!0(?!\\.00))([1-4]\\d{4}|5000000)(\\.\\d{1,2})?$")
    private Double sellingPrice;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(?!0(?!\\.00))([1-4]\\d{4}|5000000)(\\.\\d{1,2})?$")
    private Double entryPrice;
    private ProductTypeDTO productType;
    private Set<ProductSizeDTO> productSizes;
    private boolean isDelete = false;
    public ProductCreateDTO() {
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


    public Double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(Double entryPrice) {
        this.entryPrice = entryPrice;
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

    public ProductTypeDTO getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeDTO productType) {
        this.productType = productType;
    }

    public Set<ProductSizeDTO> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(Set<ProductSizeDTO> productSizes) {
        this.productSizes = productSizes;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
