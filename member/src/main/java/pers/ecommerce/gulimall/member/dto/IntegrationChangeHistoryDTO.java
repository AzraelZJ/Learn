package pers.ecommerce.gulimall.member.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 积分变化历史记录
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "积分变化历史记录")
public class IntegrationChangeHistoryDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "member_id")
	private Long memberId;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "变化的值")
	private Integer changeCount;

	@ApiModelProperty(value = "备注")
	private String note;

	@ApiModelProperty(value = "来源：[0: 购物; 1: 管理员修改; 2: 活动]")
	private Integer sourceType;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}