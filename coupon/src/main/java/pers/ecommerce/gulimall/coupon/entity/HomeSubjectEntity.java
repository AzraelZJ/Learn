package pers.ecommerce.gulimall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 首页专题表（JD首页下面很多专题，每个专题链接新的页面，展示专题商品信息）
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("cms_home_subject")
public class HomeSubjectEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 专题名字
     */
	private String name;

    /**
     * 专题标题
     */
	private String title;

    /**
     * 专题副标题
     */
	private String subTitle;

    /**
     * 显示状态
     */
	private Integer status;

    /**
     * 详情连接
     */
	private String url;

    /**
     * 排序
     */
	private Integer sort;

    /**
     * 专题图片地址
     */
	private String img;
}