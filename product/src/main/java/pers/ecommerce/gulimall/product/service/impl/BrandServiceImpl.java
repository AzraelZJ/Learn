package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.common.utils.ConvertUtils;
import pers.ecommerce.gulimall.product.dao.BrandDao;
import pers.ecommerce.gulimall.product.dao.CategoryBrandRelationDao;
import pers.ecommerce.gulimall.product.dto.BrandDTO;
import pers.ecommerce.gulimall.product.entity.BrandEntity;
import pers.ecommerce.gulimall.product.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pers.ecommerce.gulimall.product.service.CategoryBrandRelationService;

import java.util.Map;

/**
 * 品牌
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class BrandServiceImpl extends CrudServiceImpl<BrandDao, BrandEntity, BrandDTO> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Autowired
    CategoryBrandRelationDao categoryBrandRelationDao;

    @Override
    public QueryWrapper<BrandEntity> getWrapper(Map<String, Object> params) {

        String brandId = (String) params.get("brandId");

        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(brandId), "brand_id", brandId);

        return wrapper;
    }

    /**
     * 更新品牌信息时，同步更新其它表内涉及的品牌信息
     *
     * @param brandDTO 品牌信息
     */
    @Override
    @Transactional
    public void updateBrand(BrandDTO brandDTO) {

        /*
         * 保证冗余字段的数据一致：
         * 1. 更新当前表
         */
        BrandEntity brandEntity = ConvertUtils.sourceToTarget(brandDTO, currentModelClass());
        updateById(brandEntity);

        if (StringUtils.isEmpty(brandDTO.getName())) {
            // 2. 同步更新其它关联表中的数据
            categoryBrandRelationService.updateBrandInfo(brandDTO.getBrandId(), brandDTO.getName());

            // TODO 更新其它关联
        }
    }
}