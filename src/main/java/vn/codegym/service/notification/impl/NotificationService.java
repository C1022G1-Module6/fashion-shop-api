package vn.codegym.service.notification.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import vn.codegym.dto.employee.EmployeeDTO;
import vn.codegym.dto.notification.NotificationDTO;
import vn.codegym.entity.employee.Employee;
import vn.codegym.entity.notification.Notification;
import vn.codegym.repository.notification.INotificationRepository;
import vn.codegym.service.notification.INotificationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService implements INotificationService {
    @Autowired
    private INotificationRepository notificationRepository;
    @Override
    public Page<NotificationDTO> getAll(Pageable pageable) {
      List<NotificationDTO> notificationDTOS = new ArrayList<>() ;
        Page<Notification> notifications =  notificationRepository.getAll(pageable);
        NotificationDTO notificationDTO;
        for (Notification notification: notifications ){
            notificationDTO = new NotificationDTO();
            notificationDTO.setEmployeeDTO(new EmployeeDTO());
            BeanUtils.copyProperties(notification.getEmployee(), notificationDTO.getEmployeeDTO());
            BeanUtils.copyProperties(notification, notificationDTO);
            notificationDTOS.add(notificationDTO);
        }
        return new PageImpl<>(notificationDTOS,pageable , notifications.getTotalElements());
    }

    @Override
    public void addNotification(Notification notification) {
        notificationRepository.createNotification(notification);

    }

    @Override
    public NotificationDTO findByIdNotification(Integer id) {
        Notification notification =  notificationRepository.findById(id).get();
        if (notification == null) {
            // handle the case where the notification is not found
            return null;
        }
        NotificationDTO notificationDTO =new NotificationDTO();
        notificationDTO.setEmployeeDTO(new EmployeeDTO());
        BeanUtils.copyProperties(notification.getEmployee(), notificationDTO.getEmployeeDTO());
        BeanUtils.copyProperties(notification, notificationDTO);






        return notificationDTO ;
    }
}