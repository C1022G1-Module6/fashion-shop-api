package vn.codegym.service.notification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.notification.NotificationDTO;
import vn.codegym.entity.notification.Notification;


public interface INotificationService {
    Page<NotificationDTO> getAll(Pageable pageable);

    void addNotification(Notification notification);



    NotificationDTO findByIdNotification(Integer id);
}
