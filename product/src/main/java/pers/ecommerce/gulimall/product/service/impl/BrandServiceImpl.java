package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.product.controller.dao.BrandDao;
import pers.ecommerce.gulimall.product.dto.BrandDTO;
import pers.ecommerce.gulimall.product.entity.BrandEntity;
import pers.ecommerce.gulimall.product.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 品牌
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class BrandServiceImpl extends CrudServiceImpl<BrandDao, BrandEntity, BrandDTO> implements BrandService {

    @Override
    public QueryWrapper<BrandEntity> getWrapper(Map<String, Object> params){
        String brandId = params.get("brand_id").toString();

        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(brandId), "brand_id", brandId);

        return wrapper;
    }


}