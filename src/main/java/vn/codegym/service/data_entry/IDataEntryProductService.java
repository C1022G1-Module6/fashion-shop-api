package vn.codegym.service.data_entry;

import vn.codegym.dto.data_entry.DataEntryProductDTO;

public interface IDataEntryProductService {
    void saveEntryProduct(DataEntryProductDTO dataEntryProductDTO);

    void delete(Integer id);
}
