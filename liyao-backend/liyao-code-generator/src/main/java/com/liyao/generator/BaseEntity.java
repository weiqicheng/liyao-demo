package com.liyao.generator;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共字段
 */
@Data
public class BaseEntity implements Serializable {

    public static final String ID = "ID";
    public static final String CREATE_DATE = "CREATE_DATE";
    public static final String CREATE_BY = "CREATE_BY";
    public static final String UPDATE_DATE = "UPDATE_DATE";
    public static final String UPDATE_BY = "UPDATE_BY";
    public static final String VERSION = "VERSION";
    public static final String IS_DELETE = "IS_DELETE";
    /**
     * 用户ID
     */
    @TableId(value = "id")
    private String id;

    @TableField(value = "create_by")
    private String createBy;

    @TableField(fill = FieldFill.INSERT, value = "create_date", strategy = FieldStrategy.NOT_EMPTY)
    private Date createDate;

    @TableField(value = "update_by")
    private String updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE, value = "update_date", strategy = FieldStrategy.NOT_EMPTY)
    private Date updateDate;

    @TableField(fill = FieldFill.INSERT, value = "is_delete", strategy = FieldStrategy.NOT_EMPTY)
    private String isDelete;

    @TableField(fill = FieldFill.INSERT, value = "version", strategy = FieldStrategy.NOT_EMPTY)
    private Long version;

}
