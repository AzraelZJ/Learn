package pers.ecommerce.gulimall.product.service;

import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.CrudService;
import pers.ecommerce.gulimall.product.dto.AttrGroupDTO;
import pers.ecommerce.gulimall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
public interface AttrGroupService extends CrudService<AttrGroupEntity, AttrGroupDTO> {

    /**
     * 分页的模糊查询
     *
     * @param params 请求参数
     * @param catId 商品三级分类id
     * @return 分页结果
     */
    PageData<AttrGroupDTO> fuzzyQuery(Map<String, Object> params, Long catId);
}