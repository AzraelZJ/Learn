package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.common.utils.ConvertUtils;
import pers.ecommerce.gulimall.product.dao.AttrAttrgroupRelationDao;
import pers.ecommerce.gulimall.product.dao.AttrDao;
import pers.ecommerce.gulimall.product.dao.AttrGroupDao;
import pers.ecommerce.gulimall.product.dto.AttrAttrgroupRelationDTO;
import pers.ecommerce.gulimall.product.dto.AttrDTO;
import pers.ecommerce.gulimall.product.entity.AttrAttrgroupRelationEntity;
import pers.ecommerce.gulimall.product.entity.AttrEntity;
import pers.ecommerce.gulimall.product.entity.AttrGroupEntity;
import pers.ecommerce.gulimall.product.service.AttrAttrgroupRelationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 属性&属性分组关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class AttrAttrgroupRelationServiceImpl extends CrudServiceImpl<AttrAttrgroupRelationDao, AttrAttrgroupRelationEntity, AttrAttrgroupRelationDTO> implements AttrAttrgroupRelationService {

    @Autowired
    AttrDao attrDao;

    @Autowired
    AttrGroupDao attrGroupDao;

    @Autowired
    AttrAttrgroupRelationDao relationDao;

    @Override
    public QueryWrapper<AttrAttrgroupRelationEntity> getWrapper(Map<String, Object> params) {

        String id = (String) params.get("id");

        QueryWrapper<AttrAttrgroupRelationEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(id), "id", id);

        return wrapper;
    }

    /**
     * 依据属性分组id查询所有关联的基本属性
     *
     * @param attrGroupId 属性分组id
     * @return 属性列表
     */
    @Override
    public List<AttrDTO> getAttr(Long attrGroupId) {

        List<AttrAttrgroupRelationEntity> attrAttrgroupRelationEntityList = relationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>()
                .eq("attr_group_id", attrGroupId));
        List<Long> attrIdList = attrAttrgroupRelationEntityList.stream()
                .map(AttrAttrgroupRelationEntity::getAttrId).toList();

        ArrayList<AttrDTO> attrDTOList = new ArrayList<>();
        attrIdList.forEach(attrId -> attrDTOList.add(ConvertUtils
                .sourceToTarget(attrDao.selectById(attrId), AttrDTO.class)));

        return attrDTOList;
    }

    /**
     * 根据attrGroupId分页查询商品属性-属性分组关联关系
     *
     * @param params 参数
     * @return 分页数据
     */
    @Override
    public PageData<AttrAttrgroupRelationDTO> pageByAttrGroupId(Map<String, Object> params) {

        IPage<AttrAttrgroupRelationEntity> page = baseDao.selectPage(
                getPage(params, null, false),
                new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", params.get("attrGroupId"))
        );

        PageData<AttrAttrgroupRelationDTO> pageData = getPageData(page, currentDtoClass());
        Stream<AttrAttrgroupRelationDTO> stream = pageData.getList().stream();

        List<AttrAttrgroupRelationDTO> attrAttrgroupRelationDTOList = stream.peek(attrAttrgroupRelationDTO -> {

            Long attrId = attrAttrgroupRelationDTO.getAttrId();
            AttrEntity attrEntity = attrDao.selectById(attrId);
            if (attrEntity != null) {
                String attrName = attrEntity.getAttrName();
                String valueSelect = attrEntity.getValueSelect();

                attrAttrgroupRelationDTO.setAttrName(attrName);
                attrAttrgroupRelationDTO.setValueSelect(valueSelect);
            }
        }).toList();

        pageData.setList(attrAttrgroupRelationDTOList);

        return pageData;
    }

    /**
     * 根据attrGroupId分页查询未关联的属性
     *
     * @param params 查询参数
     * @return 查询结果
     */
    @Override
    public PageData<AttrAttrgroupRelationDTO> pageUnrelatedAttr(Map<String, Object> params) {

        // 查询当前分组id
        String currentAttrGroupIdString = (String) params.get("attrGroupId");
        long currentAttrGroupId = Integer.parseInt(currentAttrGroupIdString);

        // 查询当前属性分组id的关联关系
        List<AttrAttrgroupRelationEntity> relatedRelationEntityList = baseDao.selectList(
                new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", currentAttrGroupId));
        // 查询当前属性分组id已关联的属性id
        List<Long> relatedAttrIdList = new ArrayList<>();
        relatedRelationEntityList.forEach(relatedRelationEntity -> {
            Long relatedAttrId = relatedRelationEntity.getAttrId();
            relatedAttrIdList.add(relatedAttrId);
        });

        // 查询当前分组所关联的分类id
        Long relatedCatId = attrGroupDao.selectById(currentAttrGroupId).getCatId();
        // 构造查询条件
        QueryWrapper<AttrGroupEntity> otherAttrGroupWrapper = new QueryWrapper<AttrGroupEntity>()
                .eq("cat_id", relatedCatId).ne("attr_group_id", currentAttrGroupId);
        // 查出当前分类下的其它属性分组id
        List<Long> otherAttrGroupId = attrGroupDao.selectList(otherAttrGroupWrapper).stream()
                .map(AttrGroupEntity::getAttrGroupId).toList();

        // 查出这些分组的关联信息
        List<AttrAttrgroupRelationEntity> relationEntityList = relationDao
                .selectList(new QueryWrapper<AttrAttrgroupRelationEntity>()
                        .in("attr_group_id", otherAttrGroupId));
        // 从关联信息中查询其它属性分组关联的属性id
        List<Long> otherAttrIdList = relationEntityList.stream()
                .map(AttrAttrgroupRelationEntity::getAttrId).toList();

        // 从当前分类的所有属性中一移除这些属性，即为未被关联的属性
        List<AttrEntity> unrelatedAttrEntityList = attrDao.selectList(new QueryWrapper<AttrEntity>()
                .eq("cat_id", relatedCatId)
                .notIn("attr_id", otherAttrIdList)
                .notIn("attr_id", relatedAttrIdList));

        // 未被获取关联的属性id
        ArrayList<Long> unrelatedAttrIdList = new ArrayList<>();
        unrelatedAttrEntityList.forEach(unrelatedAttrEntity -> {
            Long attrId = unrelatedAttrEntity.getAttrId();
            unrelatedAttrIdList.add(attrId);
        });

        // 构造当前分组未被关联的属性的分页数据
        IPage<AttrAttrgroupRelationEntity> unrelatedRelationPage = baseDao.selectPage(
                getPage(params, null, false),
                new QueryWrapper<AttrAttrgroupRelationEntity>().in("attr_id", unrelatedAttrIdList)
        );

        PageData<AttrAttrgroupRelationDTO> unrelatedRelationPageData = getPageData(unrelatedRelationPage,
                currentDtoClass());

        // 从分页数据中获取未关联属性的关联信息列表
        List<AttrAttrgroupRelationDTO> unrelatedRelationDTOList = unrelatedRelationPageData.getList();

        // 向关联信息列表中添加属性名称及可选值列表信息
        int i = 0;
        for (AttrAttrgroupRelationDTO attrAttrgroupRelationDTO : unrelatedRelationDTOList) {
            attrAttrgroupRelationDTO.setAttrName(attrDao.selectById(unrelatedAttrIdList.get(i)).getAttrName());
            attrAttrgroupRelationDTO.setValueSelect(attrDao.selectById(unrelatedAttrIdList.get(i++)).getValueSelect());
        }

        // 重新设置分页信息
        unrelatedRelationPageData.setList(unrelatedRelationDTOList);

        return unrelatedRelationPageData;
    }
}