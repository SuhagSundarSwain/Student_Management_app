package com.suhag_rest_api.suhag_rest_api.MainController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class priyu {
    
    @RequestMapping("/chandi")
    public String chandi(){
        return "I love you janu";
    }
}
