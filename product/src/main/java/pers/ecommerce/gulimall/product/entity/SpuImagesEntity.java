package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * spu图片
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_spu_images")
public class SpuImagesEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;


    /**
     * spu_id
     */
	private Long spuId;

    /**
     * 图片名
     */
	private String imgName;

    /**
     * 图片地址
     */
	private String imgUrl;

    /**
     * 顺序
     */
	private Integer imgSort;

    /**
     * 是否默认图
     */
	private Integer defaultImg;
}