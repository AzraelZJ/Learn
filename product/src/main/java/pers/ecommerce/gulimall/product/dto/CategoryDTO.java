package pers.ecommerce.gulimall.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 商品三级分类
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "商品三级分类")
public class CategoryDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "分类id")
	private Long catId;

	@ApiModelProperty(value = "分类名称")
	private String name;

	@ApiModelProperty(value = "父分类id")
	private Long parentCid;

	@ApiModelProperty(value = "商品子分类")
	private List<CategoryDTO> children;

	@ApiModelProperty(value = "层级")
	private Integer catLevel;

	@ApiModelProperty(value = "是否显示[0-不显示，1显示]")
	private Integer showStatus;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "图标地址")
	private String icon;

	@ApiModelProperty(value = "计量单位")
	private String productUnit;

	@ApiModelProperty(value = "商品数量")
	private Integer productCount;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;
}