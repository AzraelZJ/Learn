package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.product.dao.AttrGroupDao;
import pers.ecommerce.gulimall.product.dto.AttrGroupDTO;
import pers.ecommerce.gulimall.product.entity.AttrGroupEntity;
import pers.ecommerce.gulimall.product.service.AttrGroupService;

import java.util.Map;

/**
 * 属性分组
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class AttrGroupServiceImpl extends CrudServiceImpl<AttrGroupDao,
        AttrGroupEntity, AttrGroupDTO> implements AttrGroupService {

    @Override
    public QueryWrapper<AttrGroupEntity> getWrapper(Map<String, Object> params) {

        String attrGroupId = (String) params.get("attrGroupId");

        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(attrGroupId), "attr_group_id", attrGroupId);

        return wrapper;
    }

    @Override
    public PageData<AttrGroupDTO> fuzzyQuery(Map<String, Object> params, Long catId) {

        if (catId == 0) {
            IPage<AttrGroupEntity> page = baseDao.selectPage(
                    getPage(params, null, false),
                    new QueryWrapper<>()
            );

            return getPageData(page, currentDtoClass());
        } else {
            String keyword = (String) params.get("keyword");
            // select * from pms_attr_group where catId=? and (attr_group_id=? or attr_group_name like %%)
            QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("cat_id", catId);
            if (!StringUtils.isEmpty(keyword)) {
                wrapper.and((obj) ->
                        obj.eq("attr_group_id", keyword).or().like("attr_group_name", keyword));
            }

            IPage<AttrGroupEntity> page = baseDao.selectPage(
                    getPage(params, null, false), wrapper
            );

            return getPageData(page, currentDtoClass());
        }
    }
}