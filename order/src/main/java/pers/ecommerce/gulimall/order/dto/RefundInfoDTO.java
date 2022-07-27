package pers.ecommerce.gulimall.order.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 退款信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "退款信息")
public class RefundInfoDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "退款的订单")
	private Long orderReturnId;

	@ApiModelProperty(value = "退款金额")
	private BigDecimal refund;

	@ApiModelProperty(value = "退款交易流水号")
	private String refundSn;

	@ApiModelProperty(value = "退款状态")
	private Integer refundStatus;

	@ApiModelProperty(value = "退款渠道：[1: 支付宝; 2: 微信; 3: 银联; 4: 汇款]")
	private Integer refundChannel;

	@ApiModelProperty(value = "")
	private String refundContent;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}