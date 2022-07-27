package pers.ecommerce.gulimall.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * spu属性值
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "spu属性值")
public class ProductAttrValueDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "商品id")
	private Long spuId;

	@ApiModelProperty(value = "属性id")
	private Long attrId;

	@ApiModelProperty(value = "属性名")
	private String attrName;

	@ApiModelProperty(value = "属性值")
	private String attrValue;

	@ApiModelProperty(value = "顺序")
	private Integer attrSort;

	@ApiModelProperty(value = "快速展示，是否展示在介绍上；[0: 否; 1： 是]")
	private Integer quickShow;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}