package pers.ecommerce.gulimall.coupon.dao;

import pers.ecommerce.gulimall.common.dao.BaseDao;
import pers.ecommerce.gulimall.coupon.entity.CouponSpuRelationEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface CouponSpuRelationDao extends BaseDao<CouponSpuRelationEntity> {
	
}