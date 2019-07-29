package com.liyao.backend.authentication.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@TableName("sys_role")
@Data
@ToString
public class SysRole {


    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 是否可用
     */
    private String isAvailable;

    /**
     * 角色详情
     */
    private String details;

   }