package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * spu信息介绍
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_spu_info_desc")
public class SpuInfoDescEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;


    /**
     * 商品id
     */
	private Long spuId;

    /**
     * 商品介绍
     */
	private String descript;
}