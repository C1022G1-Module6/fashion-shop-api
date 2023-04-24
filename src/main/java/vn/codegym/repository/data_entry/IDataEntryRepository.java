package vn.codegym.repository.data_entry;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.data_entry.DataEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface IDataEntryRepository extends JpaRepository<DataEntry, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into data_entry (code, `date`, quantity, employee_name, product_id)" +
            "values (:code, :date, :quantity, :employee_name, :product_id)", nativeQuery = true)
    void entryProduct(@Param("code") String code,
                      @Param("date") String date,
                      @Param("employee_name") String employee_name,
                      @Param("product") Integer product_id);
}
