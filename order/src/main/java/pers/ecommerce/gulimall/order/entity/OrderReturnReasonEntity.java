package pers.ecommerce.gulimall.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 退货原因
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("oms_order_return_reason")
public class OrderReturnReasonEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 退货原因名
     */
	private String name;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 启用状态
     */
	private Integer status;

    /**
     * 创建时间
     */
	private Date createTime;
}