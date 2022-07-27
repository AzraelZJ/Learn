package pers.ecommerce.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wms_purchase")
public class PurchaseEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 
     */
	private Long assigneeId;

    /**
     * 
     */
	private String assigneeName;

    /**
     * 
     */
	private String phone;

    /**
     * 
     */
	private Integer priority;

    /**
     * 
     */
	private Integer status;

    /**
     * 
     */
	private Long wareId;

    /**
     * 
     */
	private BigDecimal amount;

    /**
     * 
     */
	private Date createTime;

    /**
     * 
     */
	private Date updateTime;
}