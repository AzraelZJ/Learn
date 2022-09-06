package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.common.utils.ConvertUtils;
import pers.ecommerce.gulimall.product.dao.AttrAttrgroupRelationDao;
import pers.ecommerce.gulimall.product.dao.AttrDao;
import pers.ecommerce.gulimall.product.dto.AttrDTO;
import pers.ecommerce.gulimall.product.entity.AttrAttrgroupRelationEntity;
import pers.ecommerce.gulimall.product.entity.AttrEntity;
import pers.ecommerce.gulimall.product.service.AttrService;

import java.util.Map;

/**
 * 商品属性
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class AttrServiceImpl extends CrudServiceImpl<AttrDao, AttrEntity, AttrDTO> implements AttrService {

    @Autowired
    AttrAttrgroupRelationDao attrAttrgroupRelationDao;

    @Override
    public QueryWrapper<AttrEntity> getWrapper(Map<String, Object> params) {

        String attrId = (String) params.get("attrId");

        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(attrId), "attr_id", attrId);

        return wrapper;
    }


    /**
     * 保存商品属性信息
     *
     * @param dto 属性信息
     */
    @Override
    @Transactional
    public void saveAttr(AttrDTO dto) {

        // 保存基本数据
        AttrEntity attrEntity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        insert(attrEntity);

        // 保存关联关系
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelationEntity.setAttrGroupId(dto.getAttrGroupId());
        attrAttrgroupRelationEntity.setAttrId(dto.getAttrId());

        attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);
    }
}