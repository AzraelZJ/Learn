package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * sku信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_sku_info")
public class SkuInfoEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;


    /**
     * skuId
     */
	private Long skuId;

    /**
     * spuId
     */
	private Long spuId;

    /**
     * sku名称
     */
	private String skuName;

    /**
     * sku介绍描述
     */
	private String skuDesc;

    /**
     * 所属分类id
     */
	private Long catalogId;

    /**
     * 品牌id
     */
	private Long brandId;

    /**
     * 默认图片
     */
	private String skuDefaultImg;

    /**
     * 标题
     */
	private String skuTitle;

    /**
     * 副标题
     */
	private String skuSubtitle;

    /**
     * 价格
     */
	private BigDecimal price;

    /**
     * 销量
     */
	private Long saleCount;
}