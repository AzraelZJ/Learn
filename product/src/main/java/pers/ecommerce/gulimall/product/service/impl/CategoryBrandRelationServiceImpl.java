package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.product.controller.dao.CategoryBrandRelationDao;
import pers.ecommerce.gulimall.product.dto.CategoryBrandRelationDTO;
import pers.ecommerce.gulimall.product.entity.CategoryBrandRelationEntity;
import pers.ecommerce.gulimall.product.service.CategoryBrandRelationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class CategoryBrandRelationServiceImpl extends CrudServiceImpl<CategoryBrandRelationDao, CategoryBrandRelationEntity, CategoryBrandRelationDTO> implements CategoryBrandRelationService {

    @Override
    public QueryWrapper<CategoryBrandRelationEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<CategoryBrandRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}