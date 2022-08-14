package pers.ecommerce.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pers.ecommerce.gulimall.common.service.impl.CrudServiceImpl;
import pers.ecommerce.gulimall.product.dao.CategoryDao;
import pers.ecommerce.gulimall.product.dto.CategoryDTO;
import pers.ecommerce.gulimall.product.entity.CategoryEntity;
import pers.ecommerce.gulimall.product.service.CategoryService;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Service
public class CategoryServiceImpl extends CrudServiceImpl<CategoryDao, CategoryEntity, CategoryDTO> implements CategoryService {

    @Override
    public QueryWrapper<CategoryEntity> getWrapper(Map<String, Object> params) {

        String catId = (String) params.get("catId");

        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(catId), "cat_id", catId);

        return wrapper;
    }

    @Override
    public List<CategoryDTO> listWithTree() {

        // 1. 构建查询语句
        Map<String, Object> map = new HashMap<>(1);
        map.put("cat_id", null);

        // 2. 通过 cat_id 查出所有分类
        List<CategoryDTO> categoryDTOList = list(map);

         // 3. 组装成父子树形结构，先查出所有一级分类，再查找所有子分类
        return categoryDTOList.stream()
                .filter((categoryDTO) -> categoryDTO.getParentCid() == 0)
                .peek((menu) -> menu.setChildren(getChildren(menu, categoryDTOList)))
                .sorted(Comparator.comparingInt(CategoryDTO::getSort))
                .toList();
    }

    /**
     * 递归查找所有菜单的子菜单
     * @param currentMenu 当前菜单
     * @param children    当前菜单的子菜单
     * @return 子菜单
     */
    private List<CategoryDTO> getChildren(CategoryDTO currentMenu, List<CategoryDTO> children) {

        return children.stream()
                .filter(categoryDTO -> categoryDTO.getParentCid().equals(currentMenu.getCatId()))
                .peek(categoryDTO -> categoryDTO.setChildren(getChildren(categoryDTO, children)))
                .sorted(Comparator.comparingInt(CategoryDTO::getSort))
                .toList();
    }
}