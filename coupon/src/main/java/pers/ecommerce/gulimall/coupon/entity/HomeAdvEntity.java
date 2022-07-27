package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 首页轮播广告
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_home_adv")
public class HomeAdvEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 名字
     */
	private String name;

    /**
     * 图片地址
     */
	private String pic;

    /**
     * 开始时间
     */
	private Date startTime;

    /**
     * 结束时间
     */
	private Date endTime;

    /**
     * 状态
     */
	private Integer status;

    /**
     * 点击数
     */
	private Integer clickCount;

    /**
     * 广告详情连接地址
     */
	private String url;

    /**
     * 备注
     */
	private String note;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 发布者
     */
	private Long publisherId;

    /**
     * 审核者
     */
	private Long authId;
}