package com.liyao.backend.core.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.liyao.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author WeiMaoMao
 * @since 2019-08-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("core_sms_log")
public class SmsLog extends Model<SmsLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 消息内容
     */
    @TableField("sms_content")
    private String smsContent;


    public static final String SMS_CONTENT = "sms_content";

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
