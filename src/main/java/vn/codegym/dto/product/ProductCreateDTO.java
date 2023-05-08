package vn.codegym.dto.product;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class ProductCreateDTO {
    private String code;
    @NotBlank(message = "Không được để trống")
    @Size(max = 200,message = "Không được vượt quá 200 ký tự" )
    @Pattern(regexp = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s\\W|_]+$",message = "Tên sản phẩm phải đúng định dạng VD: Áo dài Việt Nam")
    private String name;

    private String qrImg;
    @NotBlank(message = "Không được để trống")
    private String img;

    @NotNull(message = "Không được để trống")
    private Double sellingPrice;
    @NotNull(message = "Không được để trống")
    private Double entryPrice;

    private ProductTypeDTO productType;

    private String codeDetail;
    private Set<ProductSizeDTO> productSizes;
    private boolean isDelete = false;

    public ProductCreateDTO() {
    }

    public ProductCreateDTO(String code, String name, String qrImg, String img, Double sellingPrice, Double entryPrice, ProductTypeDTO productType, Set<ProductSizeDTO> productSizes, boolean isDelete) {
        this.code = code;
        this.name = name;
        this.qrImg = qrImg;
        this.img = img;
        this.sellingPrice = sellingPrice;
        this.entryPrice = entryPrice;
        this.productType = productType;
        this.productSizes = productSizes;
        this.isDelete = isDelete;
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

    public String getCodeDetail() {
        return codeDetail;
    }

    public void setCodeDetail(String codeDetail) {
        this.codeDetail = codeDetail;
    }
}
