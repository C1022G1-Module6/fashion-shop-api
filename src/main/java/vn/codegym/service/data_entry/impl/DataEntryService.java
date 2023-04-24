package vn.codegym.service.data_entry.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.entity.data_entry.DataEntry;
import vn.codegym.repository.data_entry.IDataEntryRepository;
import vn.codegym.repository.product.IProductRepository;
import vn.codegym.service.data_entry.IDataEntryService;
import org.springframework.stereotype.Service;

@Service
public class DataEntryService implements IDataEntryService {

    @Autowired
    private IDataEntryRepository iDataEntryRepository;

    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public void entryProduct(DataEntryDTO dataEntryDTO) {
        DataEntry dataEntry = new DataEntry();
        dataEntry.setProducts(iProductRepository.findWithId(dataEntryDTO.getProductDTO());
        BeanUtils.copyProperties(dataEntryDTO, dataEntry);
        iDataEntryRepository.entryProduct(
                dataEntry.getCode(),
                dataEntry.getDate(),
                dataEntry.getQuantity(),
                dataEntry.getEmployeeName(),
                dataEntry.getProducts().);
    }
}
