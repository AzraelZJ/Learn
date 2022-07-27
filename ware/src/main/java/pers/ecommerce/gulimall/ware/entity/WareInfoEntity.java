package pers.ecommerce.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 仓库信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("wms_ware_info")
public class WareInfoEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 仓库名
     */
	private String name;

    /**
     * 仓库地址
     */
	private String address;

    /**
     * 区域编码
     */
	private String areacode;
}