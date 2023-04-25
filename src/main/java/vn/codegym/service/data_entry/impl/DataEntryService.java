package vn.codegym.service.data_entry.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.dto.customer.CustomerDTO;
import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.dto.invoice.InvoiceDTO;
import vn.codegym.dto.product.ProductDTO;
import vn.codegym.entity.data_entry.DataEntry;
import vn.codegym.entity.invoice.Invoice;
import vn.codegym.repository.data_entry.IDataEntryRepository;
import vn.codegym.service.data_entry.IDataEntryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataEntryService implements IDataEntryService {

    @Autowired
    private IDataEntryRepository iDataEntryRepository;

    /**
     *this method is applied to add new data entry instance with dataEntryDTO as a param
     *by calling method entryProduct from repository
     * this method also check whether the param is null or not
     *if null only save new invoice instance with null values
     * @param dataEntryDTO
     */
    @Override
    public void entryProduct(DataEntryDTO dataEntryDTO) {
        DataEntry dataEntry = new DataEntry();
        if (dataEntryDTO.getDataEntryProductDTOSet() == null && dataEntryDTO.getProductDTO() == null) {
            iDataEntryRepository.save(dataEntry);
        } else {
            BeanUtils.copyProperties(dataEntryDTO.getProductDTO(), dataEntry.getProduct());
            BeanUtils.copyProperties(dataEntryDTO.getDataEntryProductDTOSet(), dataEntry.getDataEntryProductSet());
            BeanUtils.copyProperties(dataEntryDTO, dataEntry);
            iDataEntryRepository.entryProduct(dataEntry.getCode(),
                    dataEntry.getDate(),
                    dataEntry.getEmployeeName(),
                    dataEntry.getProduct().getId());
        }
    }

    /**
     *this method is applied to find the last created data entry instance
     * @return
     */
    @Override
    public DataEntry findLastDataEntryInList() {
        List<DataEntry> dataEntryList = iDataEntryRepository.listAllDataEntry();
        DataEntry dataEntry = dataEntryList.get(dataEntryList.size() - 1);
        return dataEntry;
    }

    /**
     *this method is applied to update value of data entry with dataEntryDTO as param
     *by using method updateDataEntryfrom repository
     * @param dataEntryDTO
     */
    @Override
    public void update(DataEntryDTO dataEntryDTO) {
        DataEntry dataEntry = findLastDataEntryInList();
        dataEntryDTO.setId(dataEntry.getId());
        dataEntryDTO.setCode(dataEntry.getCode());
        BeanUtils.copyProperties(dataEntryDTO, dataEntry);
        iDataEntryRepository.updateDataEntry(
                dataEntry.getCode(),
                dataEntry.getDate(),
                dataEntry.getEmployeeName(),
                dataEntry.getProduct().getId(),
                dataEntry.getId());
    }

    /**
     *This function get all dataEntryDTO and return a list of data entry instances by transfer the values of list
     * created by using method listAllDataEntry from repository
     * @return
     */
    @Override
    public List<DataEntryDTO> findAll() {
        List<DataEntry> dataEntryList = iDataEntryRepository.listAllDataEntry();
        List<DataEntryDTO> dataEntryDTOList = new ArrayList<>();
        DataEntryDTO dataEntryDTO;
        for (DataEntry dataEntry: dataEntryList) {
            dataEntryDTO = new DataEntryDTO();
            dataEntryDTO.setProductDTO(new ProductDTO());
            BeanUtils.copyProperties(dataEntry.getProduct(), dataEntryDTO.getProductDTO());
            BeanUtils.copyProperties(dataEntry, dataEntryDTO);
            dataEntryDTOList.add(dataEntryDTO);
        }
        return dataEntryDTOList;
    }
}
