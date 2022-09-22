package pers.ecommerce.gulimall.product.service;

import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.CrudService;
import pers.ecommerce.gulimall.product.dto.AttrDTO;
import pers.ecommerce.gulimall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
public interface AttrService extends CrudService<AttrEntity, AttrDTO> {

    /**
     * 保存商品属性信息
     *
     * @param dto 属性信息
     */
    void saveAttr(AttrDTO dto);

    /**
     * 分页模糊查询
     *
     * @param params   请求参数
     * @param catId    商品三级分类id
     * @param attrType 属性类型
     * @return 查询结果
     */
    PageData<AttrDTO> fuzzyQuery(Map<String, Object> params, Long catId);

    /**
     * 分页查询
     * @param params 请求参数
     * @return 查询结果
     */
    PageData<AttrDTO> page(Map<String, Object> params);

    /**
     * 查询单条数据
     * @param attrId 属性id
     * @return 查询结果
     */
    AttrDTO getAttr(Long attrId);

    /**
     * 修改商品属性信息
     * @param attrDTO 商品属性DTO
     */
    void updateAttr(AttrDTO attrDTO);
}