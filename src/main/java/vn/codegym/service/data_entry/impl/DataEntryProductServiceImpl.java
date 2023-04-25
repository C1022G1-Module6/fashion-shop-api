package vn.codegym.service.data_entry.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.dto.data_entry.DataEntryProductDTO;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.dto.invoice.InvoiceDetailDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.entity.data_entry.DataEntryProduct;
import vn.codegym.entity.invoice.InvoiceDetail;
import vn.codegym.repository.data_entry.IDataEntryProductRepository;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.service.data_entry.IDataEntryProductService;
import vn.codegym.service.data_entry.IDataEntryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataEntryProductServiceImpl implements IDataEntryProductService {
    @Autowired
    private IDataEntryProductRepository iDataEntryProductRepository;
    @Autowired
    private IDataEntryService iDataEntryService;
    @Autowired
    private IProductRepository iProductRepository;
    Integer count = 0;

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
            DataEntryDTO dataEntryDTO = new DataEntryDTO();
            iDataEntryService.entryProduct(dataEntryDTO);
        }
        dataEntryProduct.setDataEntry(iDataEntryService.findLastDataEntryInList());
        dataEntryProduct.setProduct(iProductRepository.findWithCode(dataEntryProductDTO.getProductDTO().getCode()));
        BeanUtils.copyProperties(dataEntryProductDTO, dataEntryProduct);
        iDataEntryProductRepository.saveDataEntryProduct(dataEntryProduct.getQuantity(),
                dataEntryProduct.getDataEntry().getId(),
                dataEntryProduct.getProduct().getId());
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

    /**
     *This function get all dataEntryProductDTO instances and return a list of data entry instances
     * @return
     */
    @Override
    public List<DataEntryProductDTO> findAll() {
        List<DataEntryProduct> dataEntryProductList = iDataEntryProductRepository.listAllDataEntryProduct();
        List<DataEntryProductDTO> dataEntryProductDTOList = new ArrayList<>();
        DataEntryProductDTO dataEntryProductDTO;
        for (DataEntryProduct dataEntryProduct: dataEntryProductList) {
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
