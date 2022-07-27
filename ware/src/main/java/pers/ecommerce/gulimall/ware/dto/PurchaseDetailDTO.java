package pers.ecommerce.gulimall.ware.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import java.math.BigDecimal;

/**
 * 采购详细信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "采购详细信息")
public class PurchaseDetailDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	private Long id;

	@ApiModelProperty(value = "采购单id")
	private Long purchaseId;

	@ApiModelProperty(value = "采购商品id")
	private Long skuId;

	@ApiModelProperty(value = "采购数量")
	private Integer skuNum;

	@ApiModelProperty(value = "采购金额")
	private BigDecimal skuPrice;

	@ApiModelProperty(value = "仓库id")
	private Long wareId;

	@ApiModelProperty(value = "状态：[0: 新建; 1: 已分配; 2: 正在采购; 3: 已完成，4: 采购失败]")
	private Integer status;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}