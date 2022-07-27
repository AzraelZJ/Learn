package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品阶梯价格
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_sku_ladder")
public class SkuLadderEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * spu_id
     */
	private Long skuId;

    /**
     * 满几件享受优惠
     */
	private Integer fullCount;

    /**
     * 折扣
     */
	private BigDecimal discount;

    /**
     * 折后价
     */
	private BigDecimal price;

    /**
     * 是否叠加其他优惠：[0: 不可叠加; 1: 可叠加]
     */
	private Integer addOther;
}