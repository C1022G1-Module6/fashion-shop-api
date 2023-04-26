package vn.codegym.repository.data_entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.entity.data_entry.DataEntryProduct;

import javax.transaction.Transactional;
import java.util.List;

public interface IDataEntryProductRepository extends JpaRepository<DataEntryProduct, Integer> {

    /**
     * This function applied to add new data entry product instance to the db with params below
     * @param quantity
     * @param data_entry_id
     * @param product_id
     * @param isDelete
     */
    @Modifying
    @Transactional
    @Query(value = "insert into data_entry_product (quantity, data_entry_id, product_id, is_delete)" +
            "values (:quantity, :data_entry, :product, :isDelete)", nativeQuery = true)
    void saveDataEntryProduct(@Param("quantity") Integer quantity,
                              @Param("data_entry") Integer data_entry_id,
                              @Param("product") Integer product_id,
                              @Param("isDelete") Boolean isDelete);

    /**
     * This method is used to get the object through id
     * @param id
     * @return
     */
    @Query(value = "select * from data_entry_product where id = :id", nativeQuery = true)
    DataEntryProduct findEntryProductWithId(@Param("id") Integer id);

    /**
     * This method is used to display the list DataEntryProduct
     * @return
     */
    @Query(value = "select * from data_entry_product where is_delete = false", nativeQuery = true)
    List<DataEntryProduct> listAllDataEntryProduct();
}
