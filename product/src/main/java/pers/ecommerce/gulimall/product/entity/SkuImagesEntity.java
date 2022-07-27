package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;

/**
 * sku图片
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_sku_images")
public class SkuImagesEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;


    /**
     * sku_id
     */
	private Long skuId;

    /**
     * 图片地址
     */
	private String imgUrl;

    /**
     * 排序
     */
	private Integer imgSort;

    /**
     * 默认图：[0: 不是默认图; 1: 是默认图]
     */
	private Integer defaultImg;
}