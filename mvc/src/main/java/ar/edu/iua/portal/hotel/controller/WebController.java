package ar.edu.iua.portal.hotel.controller;

import ar.edu.iua.portal.hotel.entity.Message;
import ar.edu.iua.portal.hotel.entity.User;
import ar.edu.iua.portal.hotel.service.MessageService;
import ar.edu.iua.portal.hotel.service.SecurityService;
import ar.edu.iua.portal.hotel.service.UserService;
import ar.edu.iua.portal.hotel.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    @Qualifier("messageServiceImpl")
    private MessageService messageService;

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping({"/", "/index"})
    public String indexHandler(Model model) {
        model.addAttribute("messageForm", new Message());
        model.addAttribute("userForm", new User());
        return "index";
    }

    @PostMapping("/index")
    public String indexHandler(@ModelAttribute("messageForm") Message messageForm, Model model) {
        messageService.save(messageForm);
        model.addAttribute("messageForm", new Message());
        return "index";
    }

    @GetMapping("/register")
    public String registerHandler(Model model) {
        model.addAttribute("userForm", new User());
        return "sites/register";
    }

    @PostMapping("/register")
    public String registerHandler(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "sites/register";
        }
        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/index";
    }

    @GetMapping("/login")
    public String loginHandler(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "sites/login";
    }

}