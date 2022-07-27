package pers.ecommerce.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 成长值变化历史记录
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("mms_growth_change_history")
public class GrowthChangeHistoryEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * member_id
     */
	private Long memberId;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 改变的值（正负计数）
     */
	private Integer changeCount;

    /**
     * 备注
     */
	private String note;

    /**
     * 积分来源：[0: 购物; 1: 管理员修改]
     */
	private Integer sourceType;
}