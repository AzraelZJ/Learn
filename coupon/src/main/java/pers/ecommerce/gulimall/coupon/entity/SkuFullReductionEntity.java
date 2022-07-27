package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品满减信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_sku_full_reduction")
public class SkuFullReductionEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * spu_id
     */
	private Long skuId;

    /**
     * 满多少
     */
	private BigDecimal fullPrice;

    /**
     * 减多少
     */
	private BigDecimal reducePrice;

    /**
     * 是否参与其他优惠
     */
	private Integer addOther;
}