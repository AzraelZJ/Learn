package pers.ecommerce.gulimall.coupon.service;

import pers.ecommerce.gulimall.common.service.CrudService;
import pers.ecommerce.gulimall.coupon.dto.HomeSubjectDTO;
import pers.ecommerce.gulimall.coupon.entity.HomeSubjectEntity;

/**
 * 首页专题表（JD首页下面很多专题，每个专题链接新的页面，展示专题商品信息）
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
public interface HomeSubjectService extends CrudService<HomeSubjectEntity, HomeSubjectDTO> {

}