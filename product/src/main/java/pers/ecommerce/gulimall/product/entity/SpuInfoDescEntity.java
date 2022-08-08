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

/**
 * spu信息介绍
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_spu_info_desc")
public class SpuInfoDescEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
	@TableId
	private Long spuId;

    /**
     * 商品介绍
     */
	private String descript;

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