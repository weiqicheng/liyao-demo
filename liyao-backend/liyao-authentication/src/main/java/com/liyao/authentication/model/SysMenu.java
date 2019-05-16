package com.liyao.authentication.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@TableName("sys_menu")
@Data
@ToString
public class SysMenu {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 菜单类型：应用、菜单、模块
     */
    private String type;

    /**
     * 父级菜单id
     */
    private Integer pid;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否可用
     */
    private String isAvailable;



   }