package com.liyao.authentication.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

@TableName("sys_dict")
@Data
@ToString
public class SysDict {

    /**
     * 字典名称
     */
    @NotBlank(message = "这个参数不能为空")
//    @MyConstraint(message ="这个是提示信息")
    private String dictName;

    /**
     * 字典类型编码
     */
    @NotBlank(message = "这个参数也不能为空")
    private String typeCode;

    /**
     * 字典父级id
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