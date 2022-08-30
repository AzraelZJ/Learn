package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;

/**
 * 品牌分类关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_category_brand_relation")
public class CategoryBrandRelationEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 分类id
     */
    private Long catId;

    /**
     *
     */
    private String brandName;

    /**
     *
     */
    private String categoryName;
}