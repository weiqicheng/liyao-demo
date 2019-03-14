package com.liyao.authentication.controller;

import com.liyao.authentication.feign.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvokeFeignController {
    @Autowired
    UserAuthenticationService userAuthenticationService;
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/user1/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") String id) {
        return userAuthenticationService.testCoreFeign(id);
    }
    @RequestMapping(value = "/user2/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Long id) {
        return userAuthenticationService.get(id);
    }
}
