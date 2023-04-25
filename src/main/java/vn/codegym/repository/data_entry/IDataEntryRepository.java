package vn.codegym.repository.data_entry;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.data_entry.DataEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.entity.invoice.Invoice;

import javax.transaction.Transactional;
import java.util.List;

public interface IDataEntryRepository extends JpaRepository<DataEntry, Integer> {
    /**
     *This function applied to add new data entry instance to the db with params below
     * @param code
     * @param date
     * @param employee_name
     * @param productId
     */
    @Modifying
    @Transactional
    @Query(value = "insert into data_entry (code, `date`, quantity, employee_name, product_id)" +
            "values (:code, :date, :quantity, :employee_name, :product_id)", nativeQuery = true)
    void entryProduct(@Param("code") String code,
                      @Param("date") String date,
                      @Param("employee_name") String employee_name,
                      @Param("product") Integer productId);

    /**
     *This function get all data entry and return a list of data entry instances
     * @return returns a list of entrys
     */
    @Query(value = "select * from data_entry", nativeQuery = true)
    List<DataEntry> listAllDataEntry();

    /**
     * This method applied to update the values of data entry instance with params below
     * @param code
     * @param date
     * @param employeeName
     * @param productId
     * @param id
     */
    @Modifying
    @Transactional
    @Query(value = "update data_entry set code = :code, `date` = :date, employe_name = :employeeName, product_id = :product where id = :id", nativeQuery = true)
    void updateDataEntry(
                       @Param("code") String code,
                       @Param("date") String date,
                       @Param("employeeName") String employeeName,
                       @Param("product") Integer productId,
                       @Param("id") Integer id);
}
