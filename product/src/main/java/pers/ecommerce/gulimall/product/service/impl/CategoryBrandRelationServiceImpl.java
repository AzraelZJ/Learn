package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.product.dao.CategoryBrandRelationDao;
import pers.ecommerce.gulimall.product.dto.CategoryBrandRelationDTO;
import pers.ecommerce.gulimall.product.entity.CategoryBrandRelationEntity;
import pers.ecommerce.gulimall.product.service.BrandService;
import pers.ecommerce.gulimall.product.service.CategoryBrandRelationService;
import pers.ecommerce.gulimall.product.service.CategoryService;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class CategoryBrandRelationServiceImpl extends CrudServiceImpl<CategoryBrandRelationDao,
        CategoryBrandRelationEntity, CategoryBrandRelationDTO> implements CategoryBrandRelationService {

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Override
    public QueryWrapper<CategoryBrandRelationEntity> getWrapper(Map<String, Object> params) {

        String brandId = (String) params.get("brandId");

        QueryWrapper<CategoryBrandRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(brandId), "brand_id", brandId);

        return wrapper;
    }

    /**
     * 保存品牌 id 与商品三级分类分类 id
     *
     * @param categoryBrandRelationDTO dto
     */
    @Override
    public void saveDetail(CategoryBrandRelationDTO categoryBrandRelationDTO) {

        Long brandId = categoryBrandRelationDTO.getBrandId();
        Long catId = categoryBrandRelationDTO.getCatId();

        // 根据 id，查询品牌名称和商品三级分类名称
        String brandName = brandService.get(brandId).getName();
        String categoryName = categoryService.get(catId).getName();

        categoryBrandRelationDTO.setBrandName(brandName);
        categoryBrandRelationDTO.setCategoryName(categoryName);

        this.save(categoryBrandRelationDTO);
    }

    /**
     * 更新品牌相关信息
     *
     * @param brandId   品牌id
     * @param brandName 品牌名称
     */
    @Override
    public void updateBrandInfo(Long brandId, String brandName) {

        CategoryBrandRelationEntity categoryBrandRelationEntity = new CategoryBrandRelationEntity();
        categoryBrandRelationEntity.setBrandId(brandId);
        categoryBrandRelationEntity.setBrandName(brandName);

        UpdateWrapper<CategoryBrandRelationEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("brand_id", brandId);

        this.update(categoryBrandRelationEntity, updateWrapper);
    }

    /**
     * 更新商品三级分类相关信息
     *
     * @param catId 商品三级分类id
     * @param categoryName 商品分类名称
     */
    @Override
    public void updateCategoryInfo(Long catId, String categoryName) {

        // 使用 Mapper 接口实现
        this.baseDao.updateCategory(catId, categoryName);
    }
}