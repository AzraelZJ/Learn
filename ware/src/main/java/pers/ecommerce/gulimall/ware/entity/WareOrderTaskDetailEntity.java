package pers.ecommerce.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 库存工作单详细信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wms_ware_order_task_detail")
public class WareOrderTaskDetailEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * sku_id
     */
	private Long skuId;

    /**
     * sku_name
     */
	private String skuName;

    /**
     * 购买个数
     */
	private Integer skuNum;

    /**
     * 工作单id
     */
	private Long taskId;

    /**
     * 仓库id
     */
	private Long wareId;

    /**
     * 锁定状态：[1: 已锁定; 2: 已解锁; 3: 扣减]
     */
	private Integer lockStatus;
}