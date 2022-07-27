package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 秒杀活动商品关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_seckill_sku_relation")
public class SeckillSkuRelationEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 活动id
     */
	private Long promotionId;

    /**
     * 活动场次id
     */
	private Long promotionSessionId;

    /**
     * 商品id
     */
	private Long skuId;

    /**
     * 秒杀价格
     */
	private BigDecimal seckillPrice;

    /**
     * 秒杀总量
     */
	private BigDecimal seckillCount;

    /**
     * 每人限购数量
     */
	private BigDecimal seckillLimit;

    /**
     * 排序
     */
	private Integer seckillSort;
}