package vn.codegym.controller.notification;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.dto.employee.EmployeeDTO;
import vn.codegym.dto.notification.NotificationDTO;
import vn.codegym.entity.employee.Employee;
import vn.codegym.entity.notification.Notification;
import vn.codegym.service.notification.INotificationService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/notifications")
public class NotificationRestController {
    @Autowired
    private INotificationService notificationService;

    /**
     * display function notification
     * param: not param
     * if list notification is empty
     * @return httpStatusCode = 204
     * otherwise list notifications
     * @return httpStatusCode = 200
     */
    @GetMapping("")
    public ResponseEntity<Page<NotificationDTO>> getAll(@PageableDefault( sort = {"id"},direction = Sort.Direction.DESC,size = 4) Pageable pageable) {
        Page<NotificationDTO> notifications = notificationService.getAll(pageable);
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        }
    }

    @GetMapping("/role_saler")
    public ResponseEntity<Page<NotificationDTO>> findByRoleSaler(@PageableDefault(size = 4) Pageable pageable) {
        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        Page<NotificationDTO> notifications = notificationService.findByRoleSaler(sortedPageaBle);
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        }
    }

    @GetMapping("/role_warehouse")
    public ResponseEntity<Page<NotificationDTO>> findByRoleWareHouse(@PageableDefault(size = 4) Pageable pageable) {
        Pageable sortedPageaBle = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        Page<NotificationDTO> notifications = notificationService.findByRoleWareHouse(sortedPageaBle);
        if (notifications.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        }
    }

    /**
     *
     * id search function
     * @param id
     * if id  is null
     * @return httpStatusCode = 400
     * otherwise id
      * @return httpStatusCode = 200
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<NotificationDTO> findById( @PathVariable("id") Integer id) {
         NotificationDTO notificationDTO= notificationService.findByIdNotification(id);
         if(notificationDTO == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

         }
        return new ResponseEntity<>(notificationDTO, HttpStatus.OK);


    }

    /**
     * Notification posting function
     *
     * @param notificationDTO
     * @param bindingResult
     * if bindingResult has an error
     * @return httpStatus code = 304
     * after that copy data from notificationDTO param via notification
     * is then used to add data to the notifications if successful
     * @return http status code  = 200
     */
    @PostMapping("/create")
    public ResponseEntity<?> createNotification(@RequestBody @Validated NotificationDTO notificationDTO,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE );
        }
        Notification notification = new Notification();
        BeanUtils.copyProperties(notificationDTO, notification);
        notificationService.addNotification(notification);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
