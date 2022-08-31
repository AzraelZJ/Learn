package pers.ecommerce.gulimall.product.service;

import pers.ecommerce.gulimall.common.service.CrudService;
import pers.ecommerce.gulimall.product.dto.CategoryBrandRelationDTO;
import pers.ecommerce.gulimall.product.entity.CategoryBrandRelationEntity;

/**
 * 品牌分类关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
public interface CategoryBrandRelationService extends CrudService<CategoryBrandRelationEntity, CategoryBrandRelationDTO> {

    /**
     * 保存品牌 id 与商品三级分类分类 id
     * @param categoryBrandRelationDTO dto
     */
    void saveDetail(CategoryBrandRelationDTO categoryBrandRelationDTO);

    /**
     * 更新品牌相关数据
     *
     * @param brandId 品牌id
     * @param brandName 品牌名称
     */
    void updateBrandInfo(Long brandId, String brandName);

    /**
     * 更新商品三级分类相关信息
     *
     * @param catId 商品三级分类id
     * @param categoryName 商品分类名称
     */
    void updateCategoryInfo(Long catId, String categoryName);
}