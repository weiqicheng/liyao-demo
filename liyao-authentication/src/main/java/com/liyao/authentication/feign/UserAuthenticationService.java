package com.liyao.authentication.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//@FeignClient所在的接口中，不支持@GetMapping等组合注解
@FeignClient(value = "liyao-core",fallback = UserAuthenticationServiceFallback.class)
public interface UserAuthenticationService {
    @RequestMapping(value = "/liyao-core/{id}", method = RequestMethod.GET)
    String testCoreFeign(@PathVariable("id") String id);

    @RequestMapping(value = "/liyao-core/get/{id}", method = RequestMethod.GET)
    String get(@PathVariable("id") Long id);

}
