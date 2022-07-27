package pers.ecommerce.gulimall.ware.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 日志
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "日志")
public class UndoLogDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "")
	private Long branchId;

	@ApiModelProperty(value = "")
	private String xid;

	@ApiModelProperty(value = "")
	private String context;

	@ApiModelProperty(value = "")
	private Byte[] rollbackInfo;

	@ApiModelProperty(value = "")
	private Integer logStatus;

	@ApiModelProperty(value = "")
	private Date logCreated;

	@ApiModelProperty(value = "")
	private Date logModified;

	@ApiModelProperty(value = "")
	private String ext;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}