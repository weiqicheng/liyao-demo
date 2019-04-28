package com.liyao.authentication.exception;

public class UserNotExitException extends RuntimeException {
    private String id;
    public UserNotExitException(String id) {
        super("这是我自己定义的异常,用户不存在");
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
