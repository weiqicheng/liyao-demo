package com.liyao.authentication.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.FilterRegistration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    /**
     * 这个方法就是配置我们的异步支持的
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        //如果你想拦截异步的请求需要在这里进行注册拦截器,一个是callable一个是deferred的
//        configurer.registerCallableInterceptors(***);
//        configurer.registerDeferredResultInterceptors(***);
        //设置超时时间，在达到超时时间的时候我的http请求就返回回去
//        configurer.setDefaultTimeout(***);
        //在使用callable的时候spring是使用自己简单的不重用的线程池，在这里可以自定义自己重用的线程池
//        configurer.setTaskExecutor(***);
    }
//    @Autowired
//    private MyIntercptor myIntercptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册我们的intercptor
//        registry.addInterceptor(myIntercptor);
//    }
//
//    @Bean
//    public FilterRegistrationBean myFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        MyFilter myFilter = new MyFilter();
//        filterRegistrationBean.setFilter(myFilter);
//        //设置哪些url这个过滤器起作用。
//        List<String> urls = new ArrayList<>();
//        //所有的url都起作用。
//        urls.add("/*");
//        filterRegistrationBean.setUrlPatterns(urls);
//        return filterRegistrationBean;
//    }


}
