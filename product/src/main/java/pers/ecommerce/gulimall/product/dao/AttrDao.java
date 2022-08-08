package pers.ecommerce.gulimall.product.dao;

import pers.ecommerce.gulimall.common.dao.BaseDao;
import pers.ecommerce.gulimall.product.entity.AttrEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品属性
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-08
 */
@Mapper
public interface AttrDao extends BaseDao<AttrEntity> {
	
}