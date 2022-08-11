package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * sku销售属性&值
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_sku_sale_attr_value")
public class SkuSaleAttrValueEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;


    /**
     * sku_id
     */
	private Long skuId;

    /**
     * attr_id
     */
	private Long attrId;

    /**
     * 销售属性名
     */
	private String attrName;

    /**
     * 销售属性值
     */
	private String attrValue;

    /**
     * 顺序
     */
	private Integer attrSort;
}