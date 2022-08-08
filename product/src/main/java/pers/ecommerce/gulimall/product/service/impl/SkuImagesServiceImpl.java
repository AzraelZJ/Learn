package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.product.controller.dao.SkuImagesDao;
import pers.ecommerce.gulimall.product.dto.SkuImagesDTO;
import pers.ecommerce.gulimall.product.entity.SkuImagesEntity;
import pers.ecommerce.gulimall.product.service.SkuImagesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * sku图片
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class SkuImagesServiceImpl extends CrudServiceImpl<SkuImagesDao, SkuImagesEntity, SkuImagesDTO> implements SkuImagesService {

    @Override
    public QueryWrapper<SkuImagesEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SkuImagesEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}