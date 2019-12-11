package ar.edu.iua.portal.hotel.controller;

import ar.edu.iua.portal.hotel.entity.Message;
import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.security.SecurityService;
import ar.edu.iua.portal.hotel.service.MessageService;
import ar.edu.iua.portal.hotel.service.ReservationService;
import ar.edu.iua.portal.hotel.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class WebController {

    private static final String INDEX = "index";
    private static final String REDIRECT_INDEX = "redirect:/index";
    private static final String SITES_REGISTRATION = "sites/registration";
    private static final String SITES_LOGIN = "sites/login";
    private static final String SITES_RESERVATION = "sites/reservation";
    private static final String SITES_AUDIT = "sites/audit";
    private static final String SITES_MY_RESERVE = "sites/reservation-me";

    private static Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private SecurityService securityService;

    @Autowired
    @Qualifier("messageServiceImpl")
    private MessageService messageService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("reservationServiceImpl")
    private ReservationService reservationService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String redirectIndex() {
        return REDIRECT_INDEX;
    }

    @GetMapping("/index")
    public String indexHandler(Model model) {
        model.addAttribute("messageForm", new Message());
        model.addAttribute("userForm", new User());
        return INDEX;
    }

    @PostMapping("/index")
    public String indexHandler(@ModelAttribute("messageForm") Message messageForm, Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("Info.Post", new Object[]{"message", username}));
        messageService.save(messageForm, username, model);
        model.addAttribute("css", "success");
        model.addAttribute("message", getSourcedMessage("Sent.Message"));
        return INDEX;
    }

    @GetMapping("/registration")
    public String registrationHandler(Model model) {
        model.addAttribute("userForm", new User());
        return SITES_REGISTRATION;
    }

    @PostMapping("/registration")
    public String registrationHandler(@ModelAttribute("userForm") User userForm, Model model, BindingResult bindingResult) {
        Object[] params = new Object[]{"registration", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));

        boolean success = userService.createOrUpdate(userForm, bindingResult);
        if (success) {
            if (securityService.isAutenticated()) {
                securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());
                return REDIRECT_INDEX;
            }
            model.addAttribute("css", "success");
            model.addAttribute("message", getSourcedMessage("Success.Registration"));
        }
        return SITES_REGISTRATION;
    }

    @GetMapping("/login")
    public String loginHandler(Model model, String error, String logout) {
        Object[] params = new Object[]{"login", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Get", params));

        if (error != null) {
            model.addAttribute("css", "danger");
            model.addAttribute("message", getSourcedMessage("Invalid.UsernameOrPassword"));
        }
        return SITES_LOGIN;
    }

    @GetMapping({"/reservation"})
    public String reservationHandler(Model model) {
        model.addAttribute("reservationForm", new Reservation());
        return SITES_RESERVATION;
    }

    @PostMapping({"/reservation/{dateIn}/{dateOut}"})
    public String reservationHandler(@PathVariable("dateIn") Date dateIn, @PathVariable("dateOut") Date dateOut, Model model) {
        Reservation reservation = new Reservation();
        reservation.setCheckIn(dateIn);
        reservation.setCheckOut(dateOut);
        model.addAttribute("reservationForm", reservation);
        return SITES_RESERVATION;
    }

    @PostMapping("/reservation")
    public String reservationHandler(@ModelAttribute("reservationForm") Reservation reservationForm,
                                     BindingResult bindingResult, Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("Info.Post", new Object[]{"reservation", username}));

        boolean success = reservationService.createOrUpdate(reservationForm, username, bindingResult);
        if(success) {
            model.addAttribute("css", "success");
            model.addAttribute("message", getSourcedMessage("Success.Reservation"));
            model.addAttribute("reservationForm", new Reservation());
        }
        return SITES_RESERVATION;
    }

    @GetMapping({"/audit"})
    public String auditHandler(Model model) {
        Object[] params = new Object[]{"audit", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Get", params));

        List<Message> messages = messageService.findAllMessages();
        model.addAttribute("messages", messages);

        List<Reservation> reservations = reservationService.findAllReservations();
        model.addAttribute("reservations", reservations);

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return SITES_AUDIT;
    }

    @GetMapping("/reservation/me")
    public String myReservHandler(Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("Info.Get", new Object[]{"audit", username}));
        List<Reservation> reservations = reservationService.findReservationsByUsername(username);
        model.addAttribute("reservations", reservations);
        return SITES_MY_RESERVE;
    }

    @PostMapping("/message/{id}/delete")
    public String messageDeleteHandler(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        Object[] params = new Object[]{"audit", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));
        messageService.deleteMessage(id);
        return getOriginReq(request);
    }

    @PostMapping("/reservation/{id}/delete")
    public String reservationDeleteHandler(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        Object[] params = new Object[]{"audit", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));
        reservationService.deleteReservation(id);
        return getOriginReq(request);
    }

    @PostMapping("/user/{id}/delete")
    public String userDeleteHandler(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        Object[] params = new Object[]{"audit", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));
        userService.deleteUser(id);
        return getOriginReq(request);
    }

    @GetMapping("/reservation/{id}/update")
    public String reservationUpdateHandler(@PathVariable("id") Long id, Model model) {
        Object[] params = new Object[]{"audit", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Get", params));
        Reservation reservation = reservationService.findById(id);
        model.addAttribute("reservationForm", reservation);
        return SITES_RESERVATION;
    }

    @GetMapping("/user/password")
    public String userPasswordHandler(Model model) {
        Object[] params = new Object[]{"login", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));
        model.addAttribute("passwordForm", new PasswordForm());
        return SITES_LOGIN;
    }

    @PostMapping("/user/password/update")
    public String userPasswordUpdateHandler(@ModelAttribute("passwordForm") PasswordForm passwordForm, Model model) {
        Object[] params = new Object[]{"login", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));

        boolean success;
        String css = "success";
        String messageKey = "Success.password.change";

        success = passwordForm.getNewPassword().equals(passwordForm.getPasswordConfirm());
        if (!success) {
            css = "danger";
            messageKey = "Diff.userForm.passwordConfirm";
        } else {
            success = userService.updatePassword(passwordForm.getUsername(), passwordForm.getNewPassword(), passwordForm.getOldPassword());
            if (!success) {
                css = "danger";
                messageKey = "Invalid.UsernameOrPassword";
            }
        }
        model.addAttribute("css", css);
        model.addAttribute("message", getSourcedMessage(messageKey));
        return REDIRECT_INDEX;
    }

    private String getOriginReq(HttpServletRequest request) {
        return "redirect:"+ request.getHeader("Referer");
    }

    private String getSourcedMessage(String s) {
        return getSourcedMessage(s, null);
    }

    private String getSourcedMessage(String s, Object[] o) {
        return messageSource.getMessage(s, o, Locale.getDefault());
    }

    private static class PasswordForm {
        String username;
        String oldPassword;
        String newPassword;
        String passwordConfirm;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getOldPassword() {
            return oldPassword;
        }

        public void setOldPassword(String oldPassword) {
            this.oldPassword = oldPassword;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }

        public String getPasswordConfirm() {
            return passwordConfirm;
        }

        public void setPasswordConfirm(String passwordConfirm) {
            this.passwordConfirm = passwordConfirm;
        }
    }
}