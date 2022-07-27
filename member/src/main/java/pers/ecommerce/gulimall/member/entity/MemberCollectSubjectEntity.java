package pers.ecommerce.gulimall.member.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ecommerce.gulimall.common.entity.BaseEntity;

import java.io.Serial;

/**
 * 会员收藏的专题活动
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("mms_member_collect_subject")
public class MemberCollectSubjectEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * subject_id
     */
	private Long subjectId;

    /**
     * subject名字
     */
	private String subjectName;

    /**
     * subject图片
     */
	private String subjectImg;

    /**
     * 活动url
     */
	private String subjectUrl;
}