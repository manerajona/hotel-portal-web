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
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

@Controller
public class WebController {

    private static final String INDEX = "index";
    private static final String REGISTRATION = "sites/registration";
    private static final String LOGIN = "sites/login";
    private static final String SITES_RESERVATION = "sites/reservation";
    private static final String REDIRECT_INDEX = "redirect:/index";
    private static final String SITES_AUDIT = "sites/audit";

    private static Logger logger = Logger.getLogger(WebController.class.getName());

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
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"message", username}));

        messageForm.setUsername(username);
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
        String username = userForm.getUsername();
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"registration", username}));

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return REGISTRATION;
        }
        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return redirectIndex();
    }

    @GetMapping("/login")
    public String loginHandler(Model model, String error, String logout) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("GET_INFO", new Object[]{"logIn", username}));

        if (error != null) {
            model.addAttribute("error", getSourcedMessage("YOUR_USERNAME_AND_PASSWORD_IS_INVALID"));
        }
        if (logout != null) {
            model.addAttribute("message", getSourcedMessage("YOU_HAVE_BEEN_LOGGED_OUT_SUCCESSFULLY"));
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
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"reservation", username}));

        reservationForm.setUsername(username);

        reservationValidator.validate(reservationForm, bindingResult);

        if (!bindingResult.hasErrors()) {
            reservationService.save(reservationForm);
            model.addAttribute("message", getSourcedMessage("THE_RESERVATION_WAS_REGISTERED"));
            model.addAttribute("reservationForm", new Reservation());
        }
        return SITES_RESERVATION;

    }

    @GetMapping({"/audit"})
    public String auditnHandler(Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("GET_INFO", new Object[]{"audit", username}));

        List<Message> messages = messageService.findAllMessages();
        model.addAttribute("messages", messages);

        List<Reservation> reservations = reservationService.findAllReservations();
        model.addAttribute("reservations", reservations);

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return SITES_AUDIT;
    }

    private String getSourcedMessage(String s) {
        return getSourcedMessage(s, null);
    }

    private String getSourcedMessage(String s, Object[] o) {
        return messageSource.getMessage(s, o, Locale.getDefault());
    }
}