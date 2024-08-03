package com.suhag_rest_api.suhag_rest_api.MainController;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontedController {

    @GetMapping("/")
    public String landPage() {
        return "index";
    }

    @GetMapping("/logIn")
    public String loginPage() {
        return "logIn/LogIn";
    }

    @GetMapping("/home")
    public String home(@RequestParam String email, @RequestParam String password) {
        return "Home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("name", "Suhag Sundar Swain");
        model.addAttribute("time", new Date().toLocaleString());
        return "about";
    }

    @GetMapping("/checking")
    @ResponseBody
    public String getMethodName() {
        return new String();
    }

}
