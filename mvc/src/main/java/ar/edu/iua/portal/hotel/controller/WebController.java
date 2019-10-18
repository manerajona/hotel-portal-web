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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Locale;

@Controller
public class WebController {

    private static final String INDEX = "index";
    private static final String REDIRECT_INDEX = "redirect:/index";
    private static final String SITES_REGISTRATION = "sites/registration";
    private static final String REDIRECT_REGISTRATION = "redirect:/registration";
    private static final String SITES_LOGIN = "sites/login";
    private static final String SITES_RESERVATION = "sites/reservation";
    private static final String REDIRECT_RESERVATION = "redirect:/reservation";
    private static final String SITES_AUDIT = "sites/audit";
    private static final String REDIRECT_AUDIT = "redirect:/audit";

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
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"message", username}));
        messageService.save(messageForm, username, model);
        model.addAttribute("css", "success");
        model.addAttribute("message", getSourcedMessage("MESSAGE_SENT"));
        return INDEX;
    }

    @GetMapping("/registration")
    public String registrationHandler(Model model) {
        model.addAttribute("userForm", new User());
        return SITES_REGISTRATION;
    }

    @PostMapping("/registration")
    public String registrationHandler(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        String username = userForm.getUsername();
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"registration", username}));

        boolean hasErrors = userService.createOrUpdate(userForm, bindingResult);
        if (hasErrors) {
            return SITES_REGISTRATION;
        }
        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return redirectIndex();
    }

    @GetMapping("/login")
    public String loginHandler(Model model, String error, String logout) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("GET_INFO", new Object[]{"logIn", username}));

        if (error != null) {
            model.addAttribute("css", "danger");
            model.addAttribute("message", getSourcedMessage("YOUR_USERNAME_AND_PASSWORD_IS_INVALID"));
        }
        return SITES_LOGIN;
    }

    @GetMapping({"/reservation"})
    public String reservationHandler(Model model) {
        model.addAttribute("reservationForm", new Reservation());
        return SITES_RESERVATION;
    }

    @PostMapping("/reservation")
    public String reservationHandler(@ModelAttribute("reservationForm") Reservation reservationForm,
                                     BindingResult bindingResult, Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"reservation", username}));

        reservationService.createOrUpdate(reservationForm, username, bindingResult, model, messageSource);

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

    @PostMapping("/audit/message/{id}/delete")
    public String deleteMessage(@PathVariable("id") Long id, Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"audit", username}));
        messageService.deleteMessage(id);
        return REDIRECT_AUDIT;
    }

    @PostMapping("/audit/reservation/{id}/delete")
    public String deleteReservation(@PathVariable("id") Long id, Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"audit", username}));
        reservationService.deleteReservation(id);
        return REDIRECT_AUDIT;
    }

    @PostMapping("/audit/user/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("POST_INFO", new Object[]{"audit", username}));
        userService.deleteUser(id);
        return REDIRECT_AUDIT;
    }

    @GetMapping("/audit/reservation/{id}/update")
    public String updateReservation(@PathVariable("id") Long id, @ModelAttribute("reservationForm") Reservation reservationForm, BindingResult bindingResult, Model model) {
        String username = securityService.findLoggedInUsername();
        logger.info(getSourcedMessage("GET_INFO", new Object[]{"audit", username}));

        Reservation reservation = reservationService.findById(id);
        model.addAttribute("reservationForm", reservation);

        return SITES_RESERVATION;
    }

    private String getSourcedMessage(String s) {
        return getSourcedMessage(s, null);
    }

    private String getSourcedMessage(String s, Object[] o) {
        return messageSource.getMessage(s, o, Locale.getDefault());
    }
}