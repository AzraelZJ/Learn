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
 * 商品属性
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_attr")
public class AttrEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
	@TableId
	private Long attrId;

    /**
     * 属性名
     */
	private String attrName;

    /**
     * 是否需要检索：[0: 不需要; 1: 需要]
     */
	private Integer searchType;

    /**
     * 属性图标
     */
	private String icon;

    /**
     * 可选值列表（用逗号分隔）
     */
	private String valueSelect;

    /**
     * 属性类型：[0: 销售属性; 1: 基本属性; 2: 既是销售属性又是基本属性]
     */
	private Integer attrType;

    /**
     * 启用状态：[0: 禁用; 1: 启用]
     */
	private Long enable;

    /**
     * 所属分类
     */
	private Long catelogId;

    /**
     * 快速展示，是否展示在介绍上；[0: 否; 1: 是]，在sku中仍然可以调整
     */
	private Integer showDesc;

	/**
	 * 记录创建者
	 */
	private String creator;

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