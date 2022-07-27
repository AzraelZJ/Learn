package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 专题商品
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_home_subject_spu")
public class HomeSubjectSpuEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 专题名字
     */
	private String name;

    /**
     * 专题id
     */
	private Long subjectId;

    /**
     * spu_id
     */
	private Long spuId;

    /**
     * 排序
     */
	private Integer sort;
}