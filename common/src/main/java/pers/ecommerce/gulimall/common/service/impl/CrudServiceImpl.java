/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package pers.ecommerce.gulimall.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import org.springframework.beans.BeanUtils;
import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.CrudService;
import pers.ecommerce.gulimall.common.utils.ConvertUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * CRUD基础服务类
 *
 * @author Mark sunlightcs@gmail.com
 */
public abstract class CrudServiceImpl<M extends BaseMapper<T>, T, D> extends BaseServiceImpl<M, T> implements CrudService<T, D> {

    protected Class<D> currentDtoClass() {

        return (Class<D>) ReflectionKit.getSuperClassGenericType(getClass(), CrudServiceImpl.class, 2);
    }

    @Override
    public PageData<D> page(Map<String, Object> params) {

        IPage<T> page = baseDao.selectPage(
                getPage(params, null, false),
                getWrapper(params)
        );

        return getPageData(page, currentDtoClass());
    }

    @Override
    public List<D> list(Map<String, Object> params) {

        List<T> entityList = baseDao.selectList(getWrapper(params));

        return ConvertUtils.sourceToTarget(entityList, currentDtoClass());
    }

    public abstract QueryWrapper<T> getWrapper(Map<String, Object> params);

    @Override
    public D get(Long id) {

        T entity = baseDao.selectById(id);

        return ConvertUtils.sourceToTarget(entity, currentDtoClass());
    }

    @Override
    public void save(D dto) {

        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        insert(entity);

        // copy主键值到dto
        BeanUtils.copyProperties(entity, dto);
    }

    @Override
    public void update(D dto) {

        T entity = ConvertUtils.sourceToTarget(dto, currentModelClass());
        updateById(entity);
    }

    @Override
    public void delete(Long[] ids) {
        // TODO 检查当前删除的菜单是否被别的地方引用，若被引用则不删除
        baseDao.deleteBatchIds(Arrays.asList(ids));

        /*
         * MyBatis-Plus 逻辑删除：
         *     1. 配置全局规则（可省略）：
         *         mybatis-plus:
         *           global-config:
         *             db-config:
         *               # 配置逻辑删除
         *               logic-delete-value: 1 # 逻辑已删除值标识（默认为1）
         *               logic-not-delete-value: 0 # 逻辑未删除值标识（默认为0）
         *     2. 配置逻辑删除的组件 Bean（3.1.1 之后的版本可省略）；
         *     3. 给相应实体类字段上添加 @TableLogic 注解
         */
    }
}