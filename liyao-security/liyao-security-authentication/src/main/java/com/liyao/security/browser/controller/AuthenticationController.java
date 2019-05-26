package com.liyao.security.browser.controller;

import com.liyao.security.core.properties.SecurityProperties;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.liyao.common.response.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("authentication")
public class AuthenticationController {

    private Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    /**
     * 获得引发跳转的url
     */
    private RequestCache requestCache = new HttpSessionRequestCache();
    /**
     * 用于页面跳转,springSecurity把请求跳转的url缓存到了session中我们需要在里面拿出来。
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 自定义的配置类，可以读取自定义的配置信息
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份认证时跳转到这个控制器中
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的请求是:" + targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
                redirectStrategy.sendRedirect(request, response, securityProperties.getAuthentication().getLoginPage());
            }
        }
        return Result.fail(1, "访问的服务需要身份认证，请引导用户到登录页");
    }
}
