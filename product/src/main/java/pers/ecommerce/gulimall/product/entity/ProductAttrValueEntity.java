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
 * spu属性值
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
	@TableId
	private Long spuId;

    /**
     * 属性id
     */
	private Long attrId;

    /**
     * 属性名
     */
	private String attrName;

    /**
     * 属性值
     */
	private String attrValue;

    /**
     * 顺序
     */
	private Integer attrSort;

    /**
     * 快速展示，是否展示在介绍上；[0: 否; 1： 是]
     */
	private Integer quickShow;

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