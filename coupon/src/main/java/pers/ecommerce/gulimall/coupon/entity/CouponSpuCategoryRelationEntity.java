package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;

/**
 * 优惠券分类关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_coupon_spu_category_relation")
public class CouponSpuCategoryRelationEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 优惠券id
	 */
	private Long couponId;

	/**
	 * 产品分类id
	 */
	private Long categoryId;

	/**
	 * 产品分类名称
	 */
	private String categoryName;
}