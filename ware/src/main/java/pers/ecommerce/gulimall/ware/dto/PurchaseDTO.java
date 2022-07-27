package pers.ecommerce.gulimall.ware.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 采购信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "采购信息")
public class PurchaseDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "")
	private Long assigneeId;

	@ApiModelProperty(value = "")
	private String assigneeName;

	@ApiModelProperty(value = "")
	private String phone;

	@ApiModelProperty(value = "")
	private Integer priority;

	@ApiModelProperty(value = "")
	private Integer status;

	@ApiModelProperty(value = "")
	private Long wareId;

	@ApiModelProperty(value = "")
	private BigDecimal amount;

	@ApiModelProperty(value = "")
	private Date createTime;

	@ApiModelProperty(value = "")
	private Date updateTime;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}