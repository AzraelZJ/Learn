package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.URL;
import pers.ecommerce.gulimall.common.validator.group.AddGroup;
import pers.ecommerce.gulimall.common.validator.group.UpdateGroup;

import javax.validation.constraints.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 品牌
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_brand")
public class BrandEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * <p>品牌id</p>
     * <p>groups：分组校验</p>
     */
    @Null(message = "新增品牌不能指定品牌id，其为自增字段", groups = AddGroup.class)
    @NotNull(message = "修改品牌信息必须指定 品牌id", groups = UpdateGroup.class)
    @TableId
    private Long brandId;

    /**
     * <p>品牌名</p>
     * <P>&#064;NotBlank：校验注解，该字段必须非空且包含一个以上非空白字符</p>
     * <p>message：自定义错误信息</p>
     */
    @NotBlank(message = "必须填写品牌名称且不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;


    @NotEmpty
    @URL(message = "Logo 必须是一个合法的 URL 地址")
    private String logo;

    /**
     * 介绍
     */
    private String description;

    /**
     * 显示状态：[0: 不显示; 1: 显示]
     */
    private Integer showStatus;

    /**
     * 检索首字母
     */
    @Pattern(regexp = "/[a-zA-Z]$/", message = "检索首字母必须是单个字母")
    private String firstLetter;

    /**
     * 排序序号
     */
    @NotNull
    @Min(value = 0, message = "排序序号必须大于等于0")
    private Integer sort;

    /**
     * 记录创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private Long creator;

    /**
     * 记录创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 记录修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;
}