package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * spu信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_spu_info")
public class SpuInfoEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;


    /**
     * 商品名称
     */
	private String spuName;

    /**
     * 商品描述
     */
	private String spuDescription;

    /**
     * 所属分类id
     */
	private Long catalogId;

    /**
     * 品牌id
     */
	private Long brandId;

    /**
     * 
     */
	private BigDecimal weight;

    /**
     * 上架状态：[0: 下架; 1: 上架]
     */
	private Integer publishStatus;

    /**
     * 
     */
	private Date createTime;

    /**
     * 
     */
	private Date updateTime;
}