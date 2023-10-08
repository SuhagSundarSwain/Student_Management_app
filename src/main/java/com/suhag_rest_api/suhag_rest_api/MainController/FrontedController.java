package com.suhag_rest_api.suhag_rest_api.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontedController {
    
    @GetMapping("/")
    public String landPage(){
        return "index";
    }

}
