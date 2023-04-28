package vn.codegym.service.data_entry.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.dto.data_entry.DataEntryProductDTO;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.dto.invoice.InvoiceDetailDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.dto.product.ProductSizeDTO;
import vn.codegym.entity.data_entry.DataEntryProduct;
import vn.codegym.entity.invoice.InvoiceDetail;
import vn.codegym.entity.product.Product;
import vn.codegym.entity.product.ProductSize;
import vn.codegym.repository.data_entry.IDataEntryProductRepository;
import vn.codegym.repository.data_entry.IDataEntryRepository;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.service.data_entry.IDataEntryProductService;
import vn.codegym.service.data_entry.IDataEntryService;

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
    Integer count = 0;

    public void saveNewDataEntry() {
        DataEntryDTO dataEntryDTO = new DataEntryDTO();
        int id = iDataEntryRepository.getTotalCodeAmount();
        dataEntryDTO.setCode("MP" + id);
        dataEntryDTO.setDate(LocalDate.now().toString());
        iDataEntryService.entryProduct(dataEntryDTO);
    }

    /**
     *this method is applied to create new invoice with dataEntryProductDTO as param when this method is request,
     * it also increases count value and create new data entry instance to db by using save method from
     * iDataEntryService(only create if count = 0)
     * @param dataEntryProductDTO
     */
    @Override
    public void saveEntryProduct(DataEntryProductDTO dataEntryProductDTO) {
        DataEntryProduct dataEntryProduct = new DataEntryProduct();
        if(count == 0 ){
            saveNewDataEntry();
        }
        dataEntryProduct.setDataEntry(iDataEntryService.findLastDataEntryInList());
        dataEntryProduct.setProduct(iProductRepository.findWithCode(dataEntryProductDTO.getProductDTO().getCode()));
        BeanUtils.copyProperties(dataEntryProductDTO, dataEntryProduct);
        iDataEntryProductRepository.saveDataEntryProduct(dataEntryProduct.getQuantity(),
                dataEntryProduct.getDataEntry().getId(),
                dataEntryProduct.getProduct().getId(),
                dataEntryProduct.getDelete());
        count++;
    }

    public void resetCount() {
        count = 0 ;
    }

    /**
     * this methois applied to delete an dataEntryProduct instance by set the isDelete value to true
     * @param id
     */
    @Override
    public void delete(Integer id) {
        DataEntryProduct dataEntryProduct = iDataEntryProductRepository.findEntryProductWithId(id);
        dataEntryProduct.setDelete(true);
    }

    public void setValueOfProductSize(Product product, ProductDTO productDTO){
        Set<ProductSize> productSizeSet = product.getProductSizes();
        Set<ProductSizeDTO> productSizeDTOSet = new HashSet<>();
        ProductSizeDTO productSizeDTO;
        for (ProductSize productSize: productSizeSet){
            productSizeDTO = new ProductSizeDTO();
            BeanUtils.copyProperties(productSize, productSizeDTO);
            productSizeDTOSet.add(productSizeDTO);
        }
        productDTO.setProductSizes(productSizeDTOSet);
    }

    /**
     *This function get all dataEntryProductDTO instances and return a list of data entry instances
     * @return
     */
    @Override
    public List<DataEntryProductDTO> findAll() {
        List<DataEntryProduct> dataEntryProductList = iDataEntryProductRepository.getAllWithId(iDataEntryService.findLastDataEntryInList().getId());
        List<DataEntryProductDTO> dataEntryProductDTOList = new ArrayList<>();
        DataEntryProductDTO dataEntryProductDTO;
        for (DataEntryProduct dataEntryProduct: dataEntryProductList) {
            dataEntryProductDTO = new DataEntryProductDTO();
            dataEntryProductDTO.setDataEntryDTO(new DataEntryDTO());
            dataEntryProductDTO.setProductDTO(new ProductDTO());
            BeanUtils.copyProperties(dataEntryProduct.getDataEntry(), dataEntryProductDTO.getDataEntryDTO());
            BeanUtils.copyProperties(dataEntryProduct.getProduct(), dataEntryProductDTO.getProductDTO());
            setValueOfProductSize(dataEntryProduct.getProduct(), dataEntryProductDTO.getProductDTO());
            BeanUtils.copyProperties(dataEntryProduct, dataEntryProductDTO);
            dataEntryProductDTOList.add(dataEntryProductDTO);
        }
        return dataEntryProductDTOList;
    }
}
