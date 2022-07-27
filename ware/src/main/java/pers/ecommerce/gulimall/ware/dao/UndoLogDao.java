package pers.ecommerce.gulimall.ware.dao;

import pers.ecommerce.gulimall.common.dao.BaseDao;
import pers.ecommerce.gulimall.ware.entity.UndoLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Mapper
public interface UndoLogDao extends BaseDao<UndoLogEntity> {
	
}