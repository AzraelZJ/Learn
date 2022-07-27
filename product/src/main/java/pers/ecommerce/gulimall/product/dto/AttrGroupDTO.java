package pers.ecommerce.gulimall.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 属性分组
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "属性分组")
public class AttrGroupDTO implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "分组id")
	private Long attrGroupId;

	@ApiModelProperty(value = "组名")
	private String attrGroupName;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "描述")
	private String descript;

	@ApiModelProperty(value = "组图标")
	private String icon;

	@ApiModelProperty(value = "所属分类id")
	private Long catelogId;

	@ApiModelProperty(value = "记录创建者")
	private Long creator;

	@ApiModelProperty(value = "记录创建时间")
	private Date createDate;

	@ApiModelProperty(value = "记录修改时间")
	private Date updateDate;


}