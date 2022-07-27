/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package pers.ecommerce.gulimall.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类，所有实体都需要继承
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public abstract class BaseEntity implements Serializable {

    /**
     * id
     */
    @TableId
    private Long id;

    /**
     * 记录创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private Long creator;

    /**
     * 记录创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 记录修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;
}