package pers.ecommerce.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 退款信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("oms_refund_info")
public class RefundInfoEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 退款的订单
     */
	private Long orderReturnId;

    /**
     * 退款金额
     */
	private BigDecimal refund;

    /**
     * 退款交易流水号
     */
	private String refundSn;

    /**
     * 退款状态
     */
	private Integer refundStatus;

    /**
     * 退款渠道：[1: 支付宝; 2: 微信; 3: 银联; 4: 汇款]
     */
	private Integer refundChannel;

    /**
     * 
     */
	private String refundContent;
}