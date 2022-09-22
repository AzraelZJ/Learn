package pers.ecommerce.gulimall.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 属性&属性分组关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "属性&属性分组关联")
public class AttrAttrgroupRelationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "属性id")
    private Long attrId;

    @ApiModelProperty(value = "属性名称")
    private String attrName;

    @ApiModelProperty(value = "属性分组id")
    private Long attrGroupId;

    @ApiModelProperty(value = "可选值列表")
    private String valueSelect;

    @ApiModelProperty(value = "属性组内排序")
    private Integer attrSort;

    @ApiModelProperty(value = "记录创建者")
    private Long creator;

    @ApiModelProperty(value = "记录创建时间")
    private Date createDate;

    @ApiModelProperty(value = "记录修改时间")
    private Date updateDate;
}