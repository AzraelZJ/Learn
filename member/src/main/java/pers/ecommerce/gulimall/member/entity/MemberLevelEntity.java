package pers.ecommerce.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * 会员等级
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("mms_member_level")
public class MemberLevelEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 等级名称
     */
	private String name;

    /**
     * 等级需要的成长值
     */
	private Integer growthPoint;

    /**
     * 是否为默认等级：[0: 不是; 1:  是]
     */
	private Integer defaultStatus;

    /**
     * 免运费标准
     */
	private BigDecimal freeFreightPoint;

    /**
     * 每次评价获取的成长值
     */
	private Integer commentGrowthPoint;

    /**
     * 是否有免邮特权
     */
	private Integer privilegeFreeFreight;

    /**
     * 是否有会员价格特权
     */
	private Integer privilegeMemberPrice;

    /**
     * 是否有生日特权
     */
	private Integer privilegeBirthday;

    /**
     * 备注
     */
	private String note;
}