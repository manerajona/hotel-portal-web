package ar.edu.iua.portal.hotel.controller;

import ar.edu.iua.portal.hotel.entity.Message;
import ar.edu.iua.portal.hotel.entity.Reservation;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.security.SecurityService;
import ar.edu.iua.portal.hotel.service.MessageService;
import ar.edu.iua.portal.hotel.service.ReservationService;
import ar.edu.iua.portal.hotel.service.UserService;
import ar.edu.iua.portal.hotel.validator.ReservationValidator;
import ar.edu.iua.portal.hotel.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;

import static ar.edu.iua.portal.hotel.cons.IWeb.*;
import static ar.edu.iua.portal.hotel.cons.Imessages.*;

@Controller
public class WebController {

    public static final String ANONYMOUS_USER = "anonymousUser";
    static Logger logger = Logger.getLogger(WebController.class.getName());

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
    private UserValidator userValidator;

    @Autowired
    private ReservationValidator reservationValidator;

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
        messageService.save(messageForm);
        model.addAttribute("messageForm", new Message());
        return INDEX;
    }

    @GetMapping("/registration")
    public String registrationHandler(Model model) {
        model.addAttribute("userForm", new User());
        return REGISTRATION;
    }

    @PostMapping("/registration")
    public String registrationHandler(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        String userName = securityService.findLoggedInUsername();
        logger.info("posting registration for user : " + userName + "...");

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return REGISTRATION;
        }
        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return REDIRECT_INDEX;
    }

    @GetMapping("/login")
    public String loginHandler(Model model, String error, String logout) {
        String userName = securityService.findLoggedInUsername();
        logger.info("getting log in for user : " + userName + "...");

        if (error != null) {
            model.addAttribute("error", YOUR_USERNAME_AND_PASSWORD_IS_INVALID);
        }
        if (logout != null) {
            model.addAttribute("message", YOU_HAVE_BEEN_LOGGED_OUT_SUCCESSFULLY);
        }

        return LOGIN;
    }

    @GetMapping({"/reservation"})
    public String reservationHandler(Model model) {
        model.addAttribute("reservationForm", new Reservation());
        return SITES_RESERVATION;
    }

    @PostMapping("/reservation")
    public String reservationHandler(@ModelAttribute("reservationForm") Reservation reservationForm, BindingResult bindingResult, Model model) {

        String userName = securityService.findLoggedInUsername();
        logger.info("posting reservation for user : " + userName + "...");
        if(!ANONYMOUS_USER.equals(userName)) {
            reservationForm.setUsername(userName);

            reservationValidator.validate(reservationForm, bindingResult);

            if (!bindingResult.hasErrors()) {
                reservationService.save(reservationForm);
                model.addAttribute("message", THE_RESERVATION_WAS_REGISTERED);
                model.addAttribute("reservationForm", new Reservation());
            }
        } else {
            model.addAttribute("error", PLEASE_REGISTER_YOUR_USER);
        }

        return SITES_RESERVATION;
    }

}