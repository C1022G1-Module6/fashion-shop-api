package vn.codegym.service.data_entry.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.dto.data_entry.DataEntryProductDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.dto.product.ProductSizeDTO;
import vn.codegym.entity.data_entry.DataEntryProduct;
import vn.codegym.entity.product.Product;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.entity.product.ProductSizeDetail;
import vn.codegym.repository.data_entry.IDataEntryProductRepository;
import vn.codegym.repository.data_entry.IDataEntryRepository;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.repository.product.IProductSizeDetailRepository;
import vn.codegym.repository.product.IProductSizeRepository;
import vn.codegym.service.data_entry.IDataEntryProductService;
import vn.codegym.service.data_entry.IDataEntryService;
import vn.codegym.service.product.impl.ProductService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DataEntryProductServiceImpl implements IDataEntryProductService {
    @Autowired
    private IDataEntryProductRepository iDataEntryProductRepository;
    @Autowired
    private IDataEntryService iDataEntryService;
    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private IDataEntryRepository iDataEntryRepository;

    @Autowired
    private IProductSizeDetailRepository productSizeDetailRepository;
    @Autowired
    private IProductSizeRepository productSizeRepository;
    @Autowired
    private ProductService productService;
    Integer count = 0;

    /**
     * This method used to create code and date by date current for object dataEntryDTO
     */
    public void saveNewDataEntry() {
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        int id = iDataEntryRepository.getTotalCodeAmount() + 100000;
        dataEntryDTO.setCode("MP" + id);
        dataEntryDTO.setDate(LocalDate.now().toString());
        iDataEntryService.entryProduct(dataEntryDTO);
    }

    /**
     * this method is applied to create new invoice with dataEntryProductDTO as param when this method is request,
     * it also increases count value and create new data entry instance to db by using save method from
     * iDataEntryService(only create if count = 0)
     *
     * @param dataEntryProductDTO
     */
    @Override
    public String saveEntryProduct(DataEntryProductDTO dataEntryProductDTO) {
        ProductSize productSize = productSizeRepository.findById(Integer.parseInt(dataEntryProductDTO.getSize())).get();
        Product product = iProductRepository.findWithCode(dataEntryProductDTO.getProductDTO().getCode());
        if (product == null) {
            return "Không có mặt hàng này trong kho";
        }
        ProductSizeDetail productSizeDetail = productSizeDetailRepository.findWithProductSizeAndProduct(productSize.getId(), product.getId());
        if (productSizeDetail == null) {
            return "Không có mặt hàng này trong kho";
        }
        if (count == 0) {
            saveNewDataEntry();
        }
        DataEntryProduct dataEntryProduct = new DataEntryProduct();
        dataEntryProductDTO.setProductSizeCode(product.getCode() + productSize.getName());
        BeanUtils.copyProperties(dataEntryProductDTO, dataEntryProduct);
        dataEntryProduct.setDataEntry(iDataEntryService.findLastDataEntryInList());
        dataEntryProduct.setProduct(productSizeDetail.getProduct());
        productSizeDetail.setQuantity(productSizeDetail.getQuantity() + dataEntryProduct.getQuantity());
        productSizeDetailRepository.save(productSizeDetail);
        productService.setValueForProduct(product);
        List<DataEntryProduct> dataEntryProducts = iDataEntryProductRepository.findAll();

        if (dataEntryProducts.isEmpty()) {
            iDataEntryProductRepository.save(dataEntryProduct);
        }

        DataEntryProduct dataEntryProduct1 = dataEntryProducts.get(dataEntryProducts.size() - 1);
        if (dataEntryProductDTO.getProductSizeCode().equals(dataEntryProduct1.getProductSizeCode()) && count != 0) {
            dataEntryProduct1.setQuantity(dataEntryProduct1.getQuantity() + dataEntryProductDTO.getQuantity());
            iDataEntryProductRepository.save(dataEntryProduct1);
        } else {
            iDataEntryProductRepository.saveDataEntryProduct(dataEntryProduct.getQuantity(),
                    dataEntryProduct.getDataEntry().getId(),
                    dataEntryProduct.getProduct().getId(),
                    productSize.getName(),
                    dataEntryProduct.getProductSizeCode(),
                    dataEntryProduct.getDelete());
        }

        count++;
        return "";
    }

    public void resetCount() {
        count = 0;
    }

    /**
     * this methois applied to delete an dataEntryProduct instance by set the isDelete value to true
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        DataEntryProduct dataEntryProduct = iDataEntryProductRepository.findEntryProductWithId(id);
        dataEntryProduct.setDelete(true);
        iDataEntryProductRepository.save(dataEntryProduct);
    }


    /**
     * This function get all dataEntryProductDTO instances and return a list of data entry instances
     *
     * @return
     */
    @Override
    public List<DataEntryProductDTO> findAll() {
        List<DataEntryProduct> dataEntryProductList = iDataEntryProductRepository
                .getAllWithId(iDataEntryService.findLastDataEntryInList().getId());
        List<DataEntryProductDTO> dataEntryProductDTOList = new ArrayList<>();
        DataEntryProductDTO dataEntryProductDTO;
        for (DataEntryProduct dataEntryProduct : dataEntryProductList) {
            dataEntryProductDTO = new DataEntryProductDTO();
            dataEntryProductDTO.setDataEntryDTO(new DataEntryDTO());
            dataEntryProductDTO.setProductDTO(new ProductDTO());
            BeanUtils.copyProperties(dataEntryProduct.getDataEntry(), dataEntryProductDTO.getDataEntryDTO());
            BeanUtils.copyProperties(dataEntryProduct.getProduct(), dataEntryProductDTO.getProductDTO());
            BeanUtils.copyProperties(dataEntryProduct, dataEntryProductDTO);
            dataEntryProductDTOList.add(dataEntryProductDTO);
        }
        return dataEntryProductDTOList;
    }
}
