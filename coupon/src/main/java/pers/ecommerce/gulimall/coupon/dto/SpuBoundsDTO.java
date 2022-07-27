package pers.ecommerce.gulimall.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 商品spu积分设置
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "商品spu积分设置")
public class SpuBoundsDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "")
	private Long spuId;

	@ApiModelProperty(value = "成长积分")
	private BigDecimal growBounds;

	@ApiModelProperty(value = "购物积分")
	private BigDecimal buyBounds;

	@ApiModelProperty(value = "优惠生效情况：[1111（四个状态位，从右到左）; 0: 无优惠，成长积分是否赠送; 1: 无优惠，购物积分是否赠送; 2: 有优惠，成长积分是否赠送; 3: 有优惠，购物积分是否赠送（[状态位0: 不赠送; 1: 赠送]）]")
	private Integer work;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}