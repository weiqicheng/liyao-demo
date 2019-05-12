package com.liyao.security.browser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("demo")
@Controller
public class DemoController {
    @GetMapping("user")
    @ResponseBody
    public String getUserList() {
        return "123";
    }

    @GetMapping("index")
    public String index() {
        return "index";
    }
}
