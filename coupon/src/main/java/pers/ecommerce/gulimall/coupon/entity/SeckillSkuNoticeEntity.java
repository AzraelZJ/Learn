package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 秒杀商品通知订阅
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_seckill_sku_notice")
public class SeckillSkuNoticeEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * member_id
     */
	private Long memberId;

    /**
     * sku_id
     */
	private Long skuId;

    /**
     * 活动场次id
     */
	private Long sessionId;

    /**
     * 订阅时间
     */
	private Date subcribeTime;

    /**
     * 发送时间
     */
	private Date sendTime;

    /**
     * 通知方式：[0: 短信; 1: 邮件]
     */
	private Integer noticeType;
}