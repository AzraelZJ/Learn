package pers.ecommerce.gulimall.product.dao;

import org.apache.ibatis.annotations.Param;
import pers.ecommerce.gulimall.common.dao.BaseDao;
import pers.ecommerce.gulimall.product.entity.CategoryBrandRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 品牌分类关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface CategoryBrandRelationDao extends BaseDao<CategoryBrandRelationEntity> {

    /**
     * 更新商品三级分类相关信息
     *
     * @param catId        商品三级分类id
     * @param categoryName 商品三级分类名称
     */
    void updateCategory(@Param("catId") Long catId, @Param("categoryName") String categoryName);
}