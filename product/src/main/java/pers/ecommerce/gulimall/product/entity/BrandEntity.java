package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 品牌
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_brand")
public class BrandEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
	@TableId
	private Long brandId;

    /**
     * 品牌名
     */
	private String name;

    /**
     * 品牌logo地址
     */
	private String logo;

    /**
     * 介绍
     */
	private String description;

    /**
     * 显示状态：[0: 不显示; 1: 显示]
     */
	private Integer showStatus;

    /**
     * 检索首字母
     */
	private String firstLetter;

    /**
     * 排序
     */
	private Integer sort;

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