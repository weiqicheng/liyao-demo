package com.liyao.backend.core.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiyaoCoreTestController {
    @Value("${server.port}")
    String port;

    @RequestMapping("liyao-core/{id}")
    public String testCore(@PathVariable("id") String id) {
        return "chengge-core:" + id + "  port:" + port;
    }


    @RequestMapping(value = "/liyao-core/get/{id}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public String get(@PathVariable("id") Long id) {
        if (id < 100) {
            return "调用成功，成哥最帅：" + port;
        } else {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
    }

    public String processHystrix_Get(@PathVariable("id") Long id) {
        return "调用失败！：" + port;
    }
}
