package vn.codegym.service.notification.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.entity.notification.Notification;
import vn.codegym.repository.notification.INotificationRepository;
import vn.codegym.service.notification.INotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private INotificationRepository notificationRepository;
    @Override
    public List<Notification> getAll() {
        return notificationRepository.getAll();
    }

    @Override
    public void addNotification(Notification notification) {
        notificationRepository.createNotification(notification);

    }
}