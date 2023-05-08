package vn.codegym.repository.notification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.entity.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface INotificationRepository extends JpaRepository<Notification, Integer> {
    @Query(value = "select * from notification "
            , nativeQuery = true)
    Page<Notification> getAll(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "insert into notification" +
            "(title," +
            "content," +
            "img," +
            "is_delete," +
            "role" +
            ")" +
            "values" +
            "(:#{#notification.title}," +
            ":#{#notification.content}," +
            ":#{#notification.img}," +
            ":#{#notification.delete}," +
            ":#{#notification.role})", nativeQuery = true)
    void createNotification(@Param("notification") Notification notification);

    @Query(value = "select * from notification where id =:id", nativeQuery = true)
    Notification findByNotificationId(@Param("id") Integer id);

    @Query(value = "select * from notification where role = 'ROLE_SALER' order by id desc   "
            , nativeQuery = true)
    Page<Notification>  findByRoleSaler(Pageable pageable);

    @Query(value = "select * from notification where role = 'ROLE_WAREHOUSE_MANAGER' order by id desc  "
            , nativeQuery = true)
    Page<Notification>  findByRoleWareHouse(Pageable pageable);
}

