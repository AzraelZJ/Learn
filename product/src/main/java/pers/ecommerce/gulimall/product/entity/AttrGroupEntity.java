package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;

/**
 * 属性分组
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_attr_group")
public class AttrGroupEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;


    /**
     * 分组id
     */
	private Long attrGroupId;

    /**
     * 组名
     */
	private String attrGroupName;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 描述
     */
	private String descript;

    /**
     * 组图标
     */
	private String icon;

    /**
     * 所属分类id
     */
	private Long catelogId;
}