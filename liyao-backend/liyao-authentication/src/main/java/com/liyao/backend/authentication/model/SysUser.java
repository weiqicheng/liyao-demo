package com.liyao.backend.authentication.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@TableName("sys_user")
@Data
@ToString
public class SysUser {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 用户真实姓名
     */
    private String trueName;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 登录用户名
     */
    private String loginName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 是否可用
     */
    private String isAvailable;
}