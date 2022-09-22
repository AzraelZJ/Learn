package pers.ecommerce.gulimall.product.service;

import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.CrudService;
import pers.ecommerce.gulimall.product.dto.AttrAttrgroupRelationDTO;
import pers.ecommerce.gulimall.product.dto.AttrDTO;
import pers.ecommerce.gulimall.product.entity.AttrAttrgroupRelationEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
public interface AttrAttrgroupRelationService extends CrudService<AttrAttrgroupRelationEntity, AttrAttrgroupRelationDTO> {

    /**
     * 依据属性分组id查询所有关联的基本属性
     *
     * @param attrGroupId 属性分组id
     * @return 属性列表
     */
    List<AttrDTO> getAttr(Long attrGroupId);

    /**
     * 根据attrGroupId分页查询商品属性-属性分组关联关系
     *
     * @param params 参数
     * @return 分页数据
     */
    PageData<AttrAttrgroupRelationDTO> pageByAttrGroupId(Map<String, Object> params);

    /**
     * 根据attrGroupId分页查询未关联的属性
     *
     * @param params 查询参数
     * @return 查询结果
     */
    PageData<AttrAttrgroupRelationDTO> pageUnrelatedAttr(Map<String, Object> params);
}