package com.liyao.security.browser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("authentication")
public class AuthenticationController {
    @RequestMapping("require")
    public String require() {
        return "login";
    }


}
