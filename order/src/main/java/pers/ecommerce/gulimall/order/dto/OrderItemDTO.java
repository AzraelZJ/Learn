package pers.ecommerce.gulimall.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 订单项信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "订单项信息")
public class OrderItemDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "order_id")
	private Long orderId;

	@ApiModelProperty(value = "订单编号")
	private String orderSn;

	@ApiModelProperty(value = "spu_id")
	private Long spuId;

	@ApiModelProperty(value = "spu名字")
	private String spuName;

	@ApiModelProperty(value = "spu_pic")
	private String spuPic;

	@ApiModelProperty(value = "品牌")
	private String spuBrand;

	@ApiModelProperty(value = "商品分类id")
	private Long categoryId;

	@ApiModelProperty(value = "商品sku编号")
	private Long skuId;

	@ApiModelProperty(value = "商品sku名字")
	private String skuName;

	@ApiModelProperty(value = "商品sku图片")
	private String skuPic;

	@ApiModelProperty(value = "商品sku价格")
	private BigDecimal skuPrice;

	@ApiModelProperty(value = "商品购买的数量")
	private Integer skuQuantity;

	@ApiModelProperty(value = "商品销售属性组合（JSON）")
	private String skuAttrsVals;

	@ApiModelProperty(value = "商品促销分解金额")
	private BigDecimal promotionAmount;

	@ApiModelProperty(value = "优惠券优惠分解金额")
	private BigDecimal couponAmount;

	@ApiModelProperty(value = "积分优惠分解金额")
	private BigDecimal integrationAmount;

	@ApiModelProperty(value = "该商品经过优惠后的分解金额")
	private BigDecimal realAmount;

	@ApiModelProperty(value = "赠送积分")
	private Integer giftIntegration;

	@ApiModelProperty(value = "赠送成长值")
	private Integer giftGrowth;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}