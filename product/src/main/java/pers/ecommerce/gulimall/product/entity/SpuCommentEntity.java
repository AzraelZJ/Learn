package pers.ecommerce.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 商品评价
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("pms_spu_comment")
public class SpuCommentEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * sku_id
     */
	private Long skuId;

    /**
     * spu_id
     */
	private Long spuId;

    /**
     * 商品名字
     */
	private String spuName;

    /**
     * 会员昵称
     */
	private String memberNickName;

    /**
     * 星级
     */
	private Integer star;

    /**
     * 会员ip
     */
	private String memberIp;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 显示状态：[0: 不显示; 1: 显示]
     */
	private Integer showStatus;

    /**
     * 购买时属性组合
     */
	private String spuAttributes;

    /**
     * 点赞数
     */
	private Integer likesCount;

    /**
     * 回复数
     */
	private Integer replyCount;

    /**
     * 评论图片/视频，JSON数据；[type: 文件类型; url: 资源路径]
     */
	private String resources;

    /**
     * 内容
     */
	private String content;

    /**
     * 用户头像
     */
	private String memberIcon;

    /**
     * 评论类型：[0: 对商品的直接评论; 1: 对评论的回复]
     */
	private Integer commentType;
}