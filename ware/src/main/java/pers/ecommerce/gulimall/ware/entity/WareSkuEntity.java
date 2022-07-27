package pers.ecommerce.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;

/**
 * 商品库存
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wms_ware_sku")
public class WareSkuEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * sku_id
     */
	private Long skuId;

    /**
     * 仓库id
     */
	private Long wareId;

    /**
     * 库存数
     */
	private Integer stock;

    /**
     * sku_name
     */
	private String skuName;

    /**
     * 锁定库存
     */
	private Integer stockLocked;
}