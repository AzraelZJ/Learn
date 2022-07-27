package pers.ecommerce.gulimall.order.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付信息表
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class PaymentInfoExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "订单号（对外业务号）")
    private String orderSn;
    @Excel(name = "订单id")
    private Long orderId;
    @Excel(name = "支付宝交易流水号")
    private String alipayTradeNo;
    @Excel(name = "支付总金额")
    private BigDecimal totalAmount;
    @Excel(name = "交易内容")
    private String subject;
    @Excel(name = "支付状态")
    private String paymentStatus;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "确认时间")
    private Date confirmTime;
    @Excel(name = "回调内容")
    private String callbackContent;
    @Excel(name = "回调时间")
    private Date callbackTime;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}