package pers.ecommerce.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 会员收藏的商品
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("mms_member_collect_spu")
public class MemberCollectSpuEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
	private Long memberId;

    /**
     * spu_id
     */
	private Long spuId;

    /**
     * spu名字
     */
	private String spuName;

    /**
     * spu图片
     */
	private String spuImg;

    /**
     * 创建时间
     */
	private Date createTime;
}