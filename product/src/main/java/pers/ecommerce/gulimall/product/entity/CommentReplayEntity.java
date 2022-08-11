package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 商品评价回复关系
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-11
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_comment_replay")
public class CommentReplayEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;


    /**
     * 评论id
     */
	private Long commentId;

    /**
     * 回复id
     */
	private Long replyId;
}