package com.liyao.security.core.properties;


public class AuthenticationProperties {
    /**
     * 如果用户配了值就用用户的值，用户没有配就用这个
     */
    private String loginPage = "/liyao-defult-login.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
