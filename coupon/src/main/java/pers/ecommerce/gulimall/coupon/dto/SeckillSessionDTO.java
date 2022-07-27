package pers.ecommerce.gulimall.coupon.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 秒杀活动场次
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "秒杀活动场次")
public class SeckillSessionDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "场次名称")
	private String name;

	@ApiModelProperty(value = "每日开始时间")
	private Date startTime;

	@ApiModelProperty(value = "每日结束时间")
	private Date endTime;

	@ApiModelProperty(value = "启用状态")
	private Integer status;

	@ApiModelProperty(value = "创建时间")
	private Date createTime;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}