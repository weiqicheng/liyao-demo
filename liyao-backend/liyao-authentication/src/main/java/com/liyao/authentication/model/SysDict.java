package com.liyao.authentication.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sys_dict")
public class SysDict {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 字典名称
     */
    @Column(name = "dict_name")
    @NotBlank(message = "这个参数不能为空")
//    @MyConstraint(message ="这个是提示信息")
    private String dictName;

    /**
     * 字典类型编码
     */
    @NotBlank(message = "这个参数也不能为空")
    @Column(name = "type_code")
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
     * 是否删除
     */
    @Column(name = "is_delete")
    private String isDelete;

    /**
     * 是否可用
     */
    @Column(name = "is_available")
    private String isAvailable;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新人
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取字典名称
     *
     * @return dict_name - 字典名称
     */
    public String getDictName() {
        return dictName;
    }

    /**
     * 设置字典名称
     *
     * @param dictName 字典名称
     */
    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    /**
     * 获取字典类型编码
     *
     * @return type_code - 字典类型编码
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 设置字典类型编码
     *
     * @param typeCode 字典类型编码
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * 获取字典父级id
     *
     * @return pid - 字典父级id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置字典父级id
     *
     * @param pid 字典父级id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否删除
     *
     * @return is_delete - 是否删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除
     *
     * @param isDelete 是否删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取是否可用
     *
     * @return is_available - 是否可用
     */
    public String getIsAvailable() {
        return isAvailable;
    }

    /**
     * 设置是否可用
     *
     * @param isAvailable 是否可用
     */
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * 获取创建人
     *
     * @return create_by - 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新人
     *
     * @return update_by - 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}