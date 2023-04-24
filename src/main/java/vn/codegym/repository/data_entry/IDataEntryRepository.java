package vn.codegym.repository.data_entry;

import vn.codegym.entity.data_entry.DataEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDataEntryRepository extends JpaRepository<DataEntry, Integer> {
}
