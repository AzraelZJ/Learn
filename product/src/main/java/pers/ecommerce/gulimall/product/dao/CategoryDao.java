package pers.ecommerce.gulimall.product.dao;

import pers.ecommerce.gulimall.common.dao.BaseDao;
import pers.ecommerce.gulimall.product.entity.CategoryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface CategoryDao extends BaseDao<CategoryEntity> {
	
}