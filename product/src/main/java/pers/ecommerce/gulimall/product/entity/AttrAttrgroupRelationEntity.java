package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;

/**
 * 属性&属性分组关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelationEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 属性id
	 */
	private Long attrId;

	/**
	 * 属性分组id
	 */
	private Long attrGroupId;

	/**
	 * 属性组内排序
	 */
	private Integer attrSort;
}