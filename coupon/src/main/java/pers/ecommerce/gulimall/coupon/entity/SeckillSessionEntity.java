package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 秒杀活动场次
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_seckill_session")
public class SeckillSessionEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 场次名称
     */
	private String name;

    /**
     * 每日开始时间
     */
	private Date startTime;

    /**
     * 每日结束时间
     */
	private Date endTime;

    /**
     * 启用状态
     */
	private Integer status;

    /**
     * 创建时间
     */
	private Date createTime;
}