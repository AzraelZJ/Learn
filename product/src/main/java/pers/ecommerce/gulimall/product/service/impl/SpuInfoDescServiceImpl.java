package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.product.dao.SpuInfoDescDao;
import pers.ecommerce.gulimall.product.dto.SpuInfoDescDTO;
import pers.ecommerce.gulimall.product.entity.SpuInfoDescEntity;
import pers.ecommerce.gulimall.product.service.SpuInfoDescService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class SpuInfoDescServiceImpl extends CrudServiceImpl<SpuInfoDescDao, SpuInfoDescEntity, SpuInfoDescDTO> implements SpuInfoDescService {

    @Override
    public QueryWrapper<SpuInfoDescEntity> getWrapper(Map<String, Object> params){
        String id = (String)params.get("id");

        QueryWrapper<SpuInfoDescEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }


}