package pers.ecommerce.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购详细信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wms_purchase_detail")
public class PurchaseDetailEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 采购单id
     */
	private Long purchaseId;

    /**
     * 采购商品id
     */
	private Long skuId;

    /**
     * 采购数量
     */
	private Integer skuNum;

    /**
     * 采购金额
     */
	private BigDecimal skuPrice;

    /**
     * 仓库id
     */
	private Long wareId;

    /**
     * 状态：[0: 新建; 1: 已分配; 2: 正在采购; 3: 已完成，4: 采购失败]
     */
	private Integer status;
}