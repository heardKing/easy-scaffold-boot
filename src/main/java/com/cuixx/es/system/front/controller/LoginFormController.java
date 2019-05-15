package com.cuixx.es.system.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginFormController {

    @GetMapping("/login")
    public String loginForm() {
        return "front/login";
    }

}
