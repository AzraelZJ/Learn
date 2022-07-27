package pers.ecommerce.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 库存工作单
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wms_ware_order_task")
public class WareOrderTaskEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * order_id
     */
	private Long orderId;

    /**
     * order_sn
     */
	private String orderSn;

    /**
     * 收货人
     */
	private String consignee;

    /**
     * 收货人电话
     */
	private String consigneeTel;

    /**
     * 配送地址
     */
	private String deliveryAddress;

    /**
     * 订单备注
     */
	private String orderComment;

    /**
     * 付款方式：[1: 在线付款; 2: 货到付款]
     */
	private Integer paymentWay;

    /**
     * 任务状态
     */
	private Integer taskStatus;

    /**
     * 订单描述
     */
	private String orderBody;

    /**
     * 物流单号
     */
	private String trackingNo;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 仓库id
     */
	private Long wareId;

    /**
     * 工作单备注
     */
	private String taskComment;
}