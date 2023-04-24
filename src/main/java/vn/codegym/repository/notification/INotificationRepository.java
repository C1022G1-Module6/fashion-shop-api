package vn.codegym.repository.notification;

import vn.codegym.entity.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepository extends JpaRepository<Notification, Integer> {
}
