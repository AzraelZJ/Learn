/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package pers.ecommerce.gulimall.modules.log.service;

import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.BaseService;
import pers.ecommerce.gulimall.modules.log.dto.SysLogOperationDTO;
import pers.ecommerce.gulimall.modules.log.entity.SysLogOperationEntity;

import java.util.List;
import java.util.Map;

/**
 * 操作日志
 *
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0
 */
public interface SysLogOperationService extends BaseService<SysLogOperationEntity> {

    PageData<SysLogOperationDTO> page(Map<String, Object> params);

    List<SysLogOperationDTO> list(Map<String, Object> params);

    void save(SysLogOperationEntity entity);
}