package pers.ecommerce.gulimall.product.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;
import pers.ecommerce.gulimall.common.validator.annotation.ListValue;
import pers.ecommerce.gulimall.common.validator.group.AddGroup;
import pers.ecommerce.gulimall.common.validator.group.UpdateGroup;
import pers.ecommerce.gulimall.common.validator.group.UpdateStatusGroup;

import javax.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * <p>品牌</p>
 * <p>groups：指定分组校验</p>
 * <p>开启分组校验后，校验规则支队 @Validated 标注的数据生效</p>
 * <p>自定义校验：</p>
 * <p>1. 编写自定义校验注解；</p>
 * <p>2. 编写自定义校验器，实现 ConstraintValidator 接口；</p>
 * <p>3. 关联自定义校验器和自定义校验注解（@Constraint(validateBy = { })，可以指定多个校验器，适配不同类型。</p>
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@ApiModel(value = "品牌")
public class BrandDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Null(message = "新增品牌不能指定品牌id，其为自增字段", groups = AddGroup.class)
    @NotNull(message = "修改品牌信息必须指定 品牌id", groups = UpdateGroup.class)
    @ApiModelProperty(value = "品牌id")
    private Long brandId;

    @NotBlank(message = "必须填写品牌名称且不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "品牌名")
    private String name;

    @NotBlank(message = "必须指定 Logo 的 URL 地址", groups = AddGroup.class)
    @URL(message = "Logo 必须是一个合法的 URL 地址")
    @ApiModelProperty(value = "品牌logo地址")
    private String logo;

    @ApiModelProperty(value = "介绍")
    private String description;

    @NotNull(groups = {AddGroup.class, UpdateStatusGroup.class})
    @ListValue(values = {0, 1}, groups = {AddGroup.class, UpdateStatusGroup.class})
    @ApiModelProperty(value = "显示状态：[0: 不显示; 1: 显示]")
    private Integer showStatus;

    @NotBlank(message = "检索首字母不能为空", groups = AddGroup.class)
    @Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是单个字母", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "检索首字母")
    private String firstLetter;

    @NotNull(message = "排序序号不能为空", groups = AddGroup.class)
    @Min(value = 0, message = "排序序号必须大于等于0", groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "排序序号")
    private Integer sort;

    @ApiModelProperty(value = "记录创建者")
    private Long creator;

    @ApiModelProperty(value = "记录创建时间")
    private Date createDate;

    @ApiModelProperty(value = "记录修改时间")
    private Date updateDate;


}