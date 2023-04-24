package vn.codegym.controller.notification;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.notification.NotificationDTO;
import vn.codegym.entity.notification.Notification;
import vn.codegym.service.notification.INotificationService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notifications")
public class NotificationRestController {
    @Autowired
    private INotificationService notificationService;

    /** display function notification
     *param: not param
     * if list notification is empty
     * *@return httpStatusCode = 204
     * otherwise list notifications
     * *@return httpStatusCode = 200
     */
    @GetMapping("")
    public ResponseEntity<List<Notification>> getAll(){
        List<Notification> notifications = notificationService.getAll();
        if (notifications.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(notifications,HttpStatus.OK);
        }
    }

    /**
     * Notification posting function
     *
     * @param notificationDTO
     * @param bindingResult
     * if bindingResult has an error
     * * @return httpStatus code = 304
     * after that copy data from notificationDTO param via notification
     * is then used to add data to the notifications if successful
     * * @return http status code  = 200
     */
    @PostMapping("/create")
    public ResponseEntity<?> createNotification(@RequestBody @Validated NotificationDTO notificationDTO,
                                                BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }

        Notification notification = new Notification();
        BeanUtils.copyProperties(notificationDTO, notification);
        notificationService.addNotification(notification);
        return  new ResponseEntity<>(HttpStatus.OK);



    }
}
