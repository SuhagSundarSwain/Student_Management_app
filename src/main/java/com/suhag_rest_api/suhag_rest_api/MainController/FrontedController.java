package com.suhag_rest_api.suhag_rest_api.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontedController {
    
    @GetMapping("/")
    public String landPage(){
        return "index";
    }

    @GetMapping("/logIn")
    public String loginPage(){
        return "logIn/LogIn";
    }

    @GetMapping("/home")
    public String home(@RequestParam String email,@RequestParam String password){
        return "Home";
    }

}
