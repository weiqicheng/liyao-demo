package com.liyao.authentication.feign;

import org.springframework.stereotype.Component;

@Component // 不要忘记添加，不要忘记添加
public class UserAuthenticationServiceFallback implements UserAuthenticationService{

    public String testCoreFeign(String id) {
        return "服务暂停了哦亲爱的！";
    }

    public String get(Long id) {
        return "服务已经暂停的哦，小垃圾！";
    }
}
