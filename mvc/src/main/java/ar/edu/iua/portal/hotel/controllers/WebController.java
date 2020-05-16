package ar.edu.iua.portal.hotel.controllers;

import ar.edu.iua.portal.hotel.GlobalExceptionHandler;
import ar.edu.iua.portal.hotel.email.EmailSender;
import ar.edu.iua.portal.hotel.model.entities.ConfirmationToken;
import ar.edu.iua.portal.hotel.model.entities.Message;
import ar.edu.iua.portal.hotel.model.entities.Reservation;
import ar.edu.iua.portal.hotel.model.entities.User;
import ar.edu.iua.portal.hotel.security.SecurityService;
import ar.edu.iua.portal.hotel.services.ConfirmationTokenService;
import ar.edu.iua.portal.hotel.services.MessageService;
import ar.edu.iua.portal.hotel.services.ReservationService;
import ar.edu.iua.portal.hotel.services.UserService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    private static final String SITES_FORGOT_PASS = "sites/forgot-password";
    private static final String SITES_RESET_PASS = "sites/reset-password";

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

    @Autowired
    private ConfirmationTokenService confirmationTokenService;

    @Autowired
    @Qualifier("emailSender")
    private EmailSender emailSender;

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

        boolean success = userService.createOrUpdateAndValidate(userForm, bindingResult);
        if (success) {
            // Auto login user
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
        if (success) {
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
        logger.info(getSourcedMessage("Info.Get", new Object[]{"reservation/me", username}));
        List<Reservation> reservations = reservationService.findReservationsByUsername(username);
        model.addAttribute("reservations", reservations);
        return SITES_MY_RESERVE;
    }

    @PostMapping("/message/{id}/delete")
    public String messageDeleteHandler(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        Object[] params = new Object[]{"message/" + id + "/delete", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));
        messageService.deleteMessage(id);
        return getOriginReq(request);
    }

    @PostMapping("/reservation/{id}/delete")
    public String reservationDeleteHandler(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        Object[] params = new Object[]{"reservation/" + id + "/delete", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));
        reservationService.deleteReservation(id);
        return getOriginReq(request);
    }

    @PostMapping("/user/{id}/delete")
    public String userDeleteHandler(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        Object[] params = new Object[]{"user/" + id + "/delete", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));
        userService.deleteUser(id);
        return getOriginReq(request);
    }

    @GetMapping("/reservation/{id}/update")
    public String reservationUpdateHandler(@PathVariable("id") Long id, Model model) {
        Object[] params = new Object[]{"reservation/{id}/update", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Get", params));
        Reservation reservation = reservationService.findById(id);
        model.addAttribute("reservationForm", reservation);
        return SITES_RESERVATION;
    }

    @GetMapping("/user/password")
    public String userPasswordHandler(Model model, HttpServletRequest request) {
        String username = securityService.findLoggedInUsername();
        Object[] params = new Object[]{"user/password", username};
        logger.info(getSourcedMessage("Info.Get", params));
        try {
            User user = userService.findByUsername(username);
            if (user == null) {
                throw new RuntimeException(HttpStatus.FORBIDDEN.getReasonPhrase());
            }
            PasswordForm passwordForm = PasswordForm.builder()
                    .username(user.getUsername())
                    .build();

            model.addAttribute("passwordForm", passwordForm);
        } catch (Exception e) {
            return getReturnToDefaultErrorView(model, request, e);
        }
        return SITES_LOGIN;
    }

    @PostMapping("/user/password/update")
    public String userPasswordUpdateHandler(@ModelAttribute("passwordForm") PasswordForm passwordForm, Model model) {
        Object[] params = new Object[]{"user/password/update", securityService.findLoggedInUsername()};
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

        return SITES_LOGIN;
    }

    @RequestMapping(value = "/user/password/forgot", method = RequestMethod.GET)
    public String displayResetPassword(Model model) {
        Object[] params = new Object[]{"user/password/forgot", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Get", params));
        model.addAttribute("userForm", new User());
        return SITES_FORGOT_PASS;
    }

    @RequestMapping(value = "/user/password/forgot", method = RequestMethod.POST)
    public String forgotUserPassword(@ModelAttribute("userForm") User userForm, HttpServletRequest request, Model model) {
        Object[] params = new Object[]{"user/password/forgot", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));

        User user = userService.findByEmail(userForm.getEmail());
        boolean success = user != null;
        if (success) {
            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            confirmationTokenService.create(confirmationToken);
            String token = confirmationToken.getConfirmationToken();

            String email = user.getEmail();
            String subject = getSourcedMessage("Email.subject");
            String from = getSourcedMessage("Email.from");
            String link = request.getLocalAddr() + ":" + request.getLocalPort() + "/user/password/reset?token=" + token;
            String content = getSourcedMessage("Email.content", new Object[]{link});

            emailSender.sendEmail(email, subject, from, content);

            model.addAttribute("css", "success");
            model.addAttribute("message", getSourcedMessage("Success.Send.Email"));
        } else {
            model.addAttribute("css", "danger");
            model.addAttribute("message", getSourcedMessage("Invalid.Email"));
        }
        return SITES_FORGOT_PASS;
    }

    @RequestMapping(value = "/user/password/reset", method = RequestMethod.GET)
    public String validateResetToken(Model model, HttpServletRequest request, @RequestParam("token") String confirmationToken) {
        Object[] params = new Object[]{"user/password/reset", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Get", params));
        try {
            ConfirmationToken token = confirmationTokenService.findByConfirmationToken(confirmationToken);
            if (token == null) {
                throw new RuntimeException(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
            PasswordForm passwordForm = PasswordForm.builder()
                    .username(token.getUser().getUsername())
                    .build();
            model.addAttribute("passwordForm", passwordForm);
            // Once used the token is deleted
            confirmationTokenService.deleteToken(token);
        } catch (Exception e) {
            return getReturnToDefaultErrorView(model, request, e);
        }
        return SITES_RESET_PASS;
    }

    @RequestMapping(value = "/user/password/reset", method = RequestMethod.POST)
    public String resetUserPassword(Model model, HttpServletRequest request, @ModelAttribute("passwordForm") PasswordForm passwordForm) {
        Object[] params = new Object[]{"user/password/reset", securityService.findLoggedInUsername()};
        logger.info(getSourcedMessage("Info.Post", params));
        try {
            boolean success;
            String css = "success";
            String messageKey = "Success.password.change";

            String username = passwordForm.getUsername();
            String newPassword = passwordForm.getNewPassword();
            String passwordConfirm = passwordForm.getPasswordConfirm();

            success = !newPassword.isEmpty() && newPassword.equals(passwordConfirm);
            if (success) {
                User user = userService.findByUsername(username);
                if (user == null) {
                    throw new RuntimeException(HttpStatus.FORBIDDEN.getReasonPhrase());
                }
                user.setPassword(newPassword);
                userService.createOrUpdate(user);
            } else {
                css = "danger";
                messageKey = "Diff.userForm.passwordConfirm";
            }
            model.addAttribute("css", css);
            model.addAttribute("message", getSourcedMessage(messageKey));
        } catch (Exception e) {
            return getReturnToDefaultErrorView(model, request, e);
        }
        return SITES_RESET_PASS;
    }

    private String getOriginReq(HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }

    private String getSourcedMessage(String s) {
        return getSourcedMessage(s, null);
    }

    private String getSourcedMessage(String s, Object[] o) {
        return messageSource.getMessage(s, o, Locale.getDefault());
    }

    private String getReturnToDefaultErrorView(Model model, HttpServletRequest request, Exception e) {
        model.addAttribute("exception", e);
        model.addAttribute("url", request);
        return GlobalExceptionHandler.DEFAULT_ERROR_VIEW;
    }

    @Setter
    @Getter
    @Builder
    private static class PasswordForm {
        String username;
        String oldPassword;
        String newPassword;
        String passwordConfirm;
    }
}