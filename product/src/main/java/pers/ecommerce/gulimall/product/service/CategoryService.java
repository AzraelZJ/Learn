package pers.ecommerce.gulimall.product.service;

import pers.ecommerce.gulimall.common.service.CrudService;
import pers.ecommerce.gulimall.product.dto.CategoryDTO;
import pers.ecommerce.gulimall.product.entity.CategoryEntity;

import java.util.List;

/**
 * 商品三级分类
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
public interface CategoryService extends CrudService<CategoryEntity, CategoryDTO> {

    /**
     * 以树形结构展示三级菜单
     * @return 菜单项
     */
    List<CategoryDTO> listWithTree();
}