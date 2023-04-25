package vn.codegym.repository.data_entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.data_entry.DataEntryProduct;
import vn.codegym.entity.invoice.InvoiceDetail;

import javax.transaction.Transactional;
import java.util.List;

public interface IDataEntryProductRepository extends JpaRepository<DataEntryProduct, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into data_entry_product (quantity, data_entry_id, product_id)" +
    "values (:quantity, :data_entry, :product)", nativeQuery = true)
    void saveDataEntryProduct(@Param("quantity") Integer quantity,
                              @Param("data_entry") Integer data_entry_id,
                              @Param("product") Integer product_id);

    @Query(value = "select * from data_entry_product where id = :id", nativeQuery = true)
    DataEntryProduct findEntryProductWithId(@Param("id") Integer id);

    @Query(value = "select * from data_entry_product where is_delete = false", nativeQuery = true)
    List<DataEntryProduct> listAllDataEntryProduct();
}
