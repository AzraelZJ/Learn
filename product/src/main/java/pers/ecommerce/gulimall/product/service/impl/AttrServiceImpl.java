package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.common.utils.ConvertUtils;
import pers.ecommerce.gulimall.product.dao.AttrAttrgroupRelationDao;
import pers.ecommerce.gulimall.product.dao.AttrDao;
import pers.ecommerce.gulimall.product.dao.AttrGroupDao;
import pers.ecommerce.gulimall.product.dao.CategoryDao;
import pers.ecommerce.gulimall.product.dto.AttrDTO;
import pers.ecommerce.gulimall.product.entity.AttrAttrgroupRelationEntity;
import pers.ecommerce.gulimall.product.entity.AttrEntity;
import pers.ecommerce.gulimall.product.entity.AttrGroupEntity;
import pers.ecommerce.gulimall.product.entity.CategoryEntity;
import pers.ecommerce.gulimall.product.service.AttrService;
import pers.ecommerce.gulimall.product.service.CategoryService;

import java.util.List;
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

    @Autowired
    AttrGroupDao attrGroupDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CategoryService categoryService;

    @Override
    public QueryWrapper<AttrEntity> getWrapper(Map<String, Object> params) {

        String attrId = (String) params.get("attrId");

        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(attrId), "attr_id", attrId);

        return wrapper;
    }

    /**
     * 在获取到的分页数据中添加 categoryName、attrGroupId、attrGroupName
     *
     * @param page 分页数据
     * @return 修改后的分页数据
     */
    @NotNull
    private PageData<AttrDTO> getFinalPageData(IPage<AttrEntity> page) {

        PageData<AttrDTO> pageData = getPageData(page, currentDtoClass());
        List<AttrDTO> oldAttrDTOList = pageData.getList();

        List<AttrDTO> newAttrDTOList = oldAttrDTOList.stream().peek(attrDTO -> {
            AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = attrAttrgroupRelationDao
                    .selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrDTO.getAttrId()));

            if (attrAttrgroupRelationEntity != null) {
                Long attrGroupId = attrAttrgroupRelationEntity.getAttrGroupId();

                attrDTO.setCategoryName(categoryDao.selectById(attrDTO.getCatId()).getName());
                attrDTO.setAttrGroupId(attrGroupId);
                attrDTO.setAttrGroupName(attrGroupDao.selectById(attrGroupId).getAttrGroupName());
            }
        }).toList();

        pageData.setList(newAttrDTOList);

        return pageData;
    }

    @Override
    public PageData<AttrDTO> page(Map<String, Object> params) {

        IPage<AttrEntity> page = baseDao.selectPage(
                getPage(params, null, false),
                getWrapper(params)
        );

        return getFinalPageData(page);
    }

    /**
     * 保存商品属性信息
     *
     * @param dto 属性信息
     */
    @Override
    // TODO 完善事务回滚功能
    @Transactional()
    public void saveAttr(AttrDTO dto) {

        System.out.println(dto);

        // 保存基本数据
        AttrEntity attrEntity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        insert(attrEntity);
        // 保存关联关系
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = new AttrAttrgroupRelationEntity();
        attrAttrgroupRelationEntity.setAttrGroupId(dto.getAttrGroupId());
        attrAttrgroupRelationEntity.setAttrId(attrEntity.getAttrId());

        attrAttrgroupRelationDao.insert(attrAttrgroupRelationEntity);
    }

    /**
     * 分页模糊查询
     *
     * @param params 请求参数
     * @param catId  商品三级分类id
     * @return 分页数据
     */
    @Override
    public PageData<AttrDTO> fuzzyQuery(Map<String, Object> params, Long catId) {

        String keyword = (String) params.get("keyword");
        // select * from pms_attr_group where catId=? and (attr_group_id=? or attr_group_name like %%)
        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(keyword)) {
            wrapper.and((obj) -> obj.eq("attr_id", keyword).or().like("attr_name", keyword));
        }

        IPage<AttrEntity> page;
        if (catId == 0) {
            page = baseDao.selectPage(
                    getPage(params, null, false), wrapper);

        } else {
            page = baseDao.selectPage(
                    getPage(params, null, false), wrapper.eq("cat_id", catId));

        }

        return getFinalPageData(page);
    }

    /**
     * 查询单条信息
     *
     * @param attrId 属性id
     * @return 查询结果
     */
    @Override
    public AttrDTO get(Long attrId) {

        AttrEntity attrEntity = baseDao.selectById(attrId);
        AttrDTO attrDTO = ConvertUtils.sourceToTarget(attrEntity, AttrDTO.class);

        // Long attrGroupId = attrAttrgroupRelationDao.selectById(attrId).getAttrGroupId();
        //
        // attrDTO.setAttrGroupId(attrGroupId);
        // attrDTO.setAttrGroupName(attrGroupDao.selectById(attrGroupId).getAttrGroupName());
        // attrDTO.setCategoryName(categoryDao.selectById(attrDTO.getCatId()).getName());

        // 设置分组信息
        AttrAttrgroupRelationEntity attrAttrgroupRelationEntity = attrAttrgroupRelationDao
                .selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", attrId));

        if (attrAttrgroupRelationEntity != null) {
            attrDTO.setAttrGroupId(attrAttrgroupRelationEntity.getAttrGroupId());
            AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attrAttrgroupRelationEntity.getAttrGroupId());

            if (attrGroupEntity != null) {
                attrDTO.setAttrGroupName(attrGroupEntity.getAttrGroupName());
            }
        }

        // 设置分类信息
        if (attrEntity != null) {
            Long catId = attrEntity.getCatId();
            Long[] catIdList = categoryService.getCatIdList(catId);
            attrDTO.setCatIdList(catIdList);

            CategoryEntity categoryEntity = categoryDao.selectById(catId);
            if (categoryEntity != null) {
                attrDTO.setCategoryName(categoryEntity.getName());
            }
        }

        return attrDTO;
    }
}