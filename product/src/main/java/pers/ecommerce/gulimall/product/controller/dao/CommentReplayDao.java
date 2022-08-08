package pers.ecommerce.gulimall.product.controller.dao;

import pers.ecommerce.gulimall.common.dao.BaseDao;
import pers.ecommerce.gulimall.product.entity.CommentReplayEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface CommentReplayDao extends BaseDao<CommentReplayEntity> {
	
}