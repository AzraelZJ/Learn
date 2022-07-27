/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package pers.ecommerce.gulimall.modules.job.service;

import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.service.BaseService;
import pers.ecommerce.gulimall.modules.job.dto.ScheduleJobLogDTO;
import pers.ecommerce.gulimall.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface ScheduleJobLogService extends BaseService<ScheduleJobLogEntity> {

	PageData<ScheduleJobLogDTO> page(Map<String, Object> params);

	ScheduleJobLogDTO get(Long id);
}
