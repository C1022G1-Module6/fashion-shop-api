package vn.codegym.service.notification;

import vn.codegym.entity.notification.Notification;

import java.util.List;

public interface INotificationService {
    List<Notification> getAll();

    void addNotification(Notification notification);
}
