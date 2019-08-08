package com.liyao.common.base;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
@Data
public abstract class BaseEntity<T extends Model<?>> extends Model<T> {
    /**
     * 主键
     */
    @Id
    private Integer id;
    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 是否删除
     */
    private String isDelete;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
