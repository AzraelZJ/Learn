package pers.ecommerce.gulimall.product.dao;

import pers.ecommerce.gulimall.common.dao.BaseDao;
import pers.ecommerce.gulimall.product.entity.CategoryBrandRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌分类关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-08-08
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseDao<CategoryBrandRelationEntity> {
	
}