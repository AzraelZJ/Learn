package pers.ecommerce.gulimall.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 会员等级
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "会员等级")
public class MemberLevelDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "等级名称")
	private String name;

	@ApiModelProperty(value = "等级需要的成长值")
	private Integer growthPoint;

	@ApiModelProperty(value = "是否为默认等级：[0: 不是; 1:  是]")
	private Integer defaultStatus;

	@ApiModelProperty(value = "免运费标准")
	private BigDecimal freeFreightPoint;

	@ApiModelProperty(value = "每次评价获取的成长值")
	private Integer commentGrowthPoint;

	@ApiModelProperty(value = "是否有免邮特权")
	private Integer privilegeFreeFreight;

	@ApiModelProperty(value = "是否有会员价格特权")
	private Integer privilegeMemberPrice;

	@ApiModelProperty(value = "是否有生日特权")
	private Integer privilegeBirthday;

	@ApiModelProperty(value = "备注")
	private String note;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}