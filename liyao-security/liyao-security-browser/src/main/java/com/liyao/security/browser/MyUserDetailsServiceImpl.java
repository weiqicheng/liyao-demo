package com.liyao.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsServiceImpl implements UserDetailsService {
    protected static Logger logger = LoggerFactory.getLogger(MyUserDetailsServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("用户名：" + username);
        String encode = passwordEncoder.encode("123456");//此处的密码是在数据库查出来的密码
        logger.info("密码为：" + encode);
        //根据用户名查找信息
        return new User(username, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
