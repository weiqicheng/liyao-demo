package com.liyao.common.base;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
public class BaseEntity {
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
}
