package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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

        String id = (String) params.get("id");

        QueryWrapper<CategoryBrandRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

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
}