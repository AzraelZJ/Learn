package pers.ecommerce.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 会员登录记录
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("mms_member_login_log")
public class MemberLoginLogEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
	private Long memberId;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * ip地址
     */
	private String ip;

    /**
     * 城市
     */
	private String city;

    /**
     * 登录类型：[1: web; 2: App]
     */
	private Integer loginType;
}