package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 秒杀活动
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_seckill_promotion")
public class SeckillPromotionEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 活动标题
     */
	private String title;

    /**
     * 开始日期
     */
	private Date startTime;

    /**
     * 结束日期
     */
	private Date endTime;

    /**
     * 上下线状态
     */
	private Integer status;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 创建人
     */
	private Long userId;
}