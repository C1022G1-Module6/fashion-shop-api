package vn.codegym.service.data_entry;

import vn.codegym.dto.data_entry.DataEntryProductDTO;

import java.util.List;

public interface IDataEntryProductService {
    void saveEntryProduct(DataEntryProductDTO dataEntryProductDTO);
    void delete(Integer id);
    List<DataEntryProductDTO> findAll();
}
