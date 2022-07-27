package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;

/**
 * 优惠券与产品关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_coupon_spu_relation")
public class CouponSpuRelationEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 优惠券id
     */
	private Long couponId;

    /**
     * spu_id
     */
	private Long spuId;

    /**
     * spu名字
     */
	private String spuName;
}