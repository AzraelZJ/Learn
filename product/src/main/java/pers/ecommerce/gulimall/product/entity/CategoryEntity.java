package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品三级分类
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_category")
public class CategoryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @TableId
    private Long catId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父分类id
     */
    private Long parentCid;

    /**
     * 商品子分类，@TableField(exist = false) 表示这个属性在数据表中不存在，是自定义属性
     */
    @TableField(exist = false)
    private List<CategoryEntity> children;

    /**
     * 层级
     */
    private Integer catLevel;

    /**
     * 是否显示 [0-不显示，1显示]
     */
    private Integer showStatus;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标地址
     */
    private String icon;

    /**
     * 计量单位
     */
    private String productUnit;

    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 记录创建者
     */
    private String creator;

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