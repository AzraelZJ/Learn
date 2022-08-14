package pers.ecommerce.gulimall.product.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.ecommerce.gulimall.common.dao.BaseDao;
import pers.ecommerce.gulimall.product.entity.BrandEntity;

/**
 * 品牌
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface BrandDao extends BaseDao<BrandEntity> {
	
}