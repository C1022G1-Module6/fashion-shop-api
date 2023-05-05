package vn.codegym.service.data_entry;

import vn.codegym.dto.data_entry.DataEntryDTO;
import vn.codegym.entity.data_entry.DataEntry;

import java.util.List;

public interface IDataEntryService {
    void entryProduct(DataEntryDTO dataEntryDTO);
    DataEntry findLastDataEntryInList();
    void update (DataEntryDTO dataEntryDTO);
    List<DataEntryDTO> findAll();

    DataEntryDTO getDataEntryDetail();
}
