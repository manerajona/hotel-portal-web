package ar.edu.iua.portal.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {
    @RequestMapping("/index")
    public String indexHandler(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String loginHandler(Model model) {
        return "sites/login";
    }

    @RequestMapping("/newUser")
    public String newUserHandler(Model model) {
        return "sites/newUser";
    }

    @RequestMapping("/reservation")
    public String loginReservation(Model model) {
        return "sites/reservation";
    }
}