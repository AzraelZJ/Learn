package pers.ecommerce.gulimall.ware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import pers.ecommerce.gulimall.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Date;

/**
 * 日志
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("undo_log")
public class UndoLogEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

    /**
     * 
     */
	private Long branchId;

    /**
     * 
     */
	private String xid;

    /**
     * 
     */
	private String context;

    /**
     * 
     */
	private Byte[] rollbackInfo;

    /**
     * 
     */
	private Integer logStatus;

    /**
     * 
     */
	private Date logCreated;

    /**
     * 
     */
	private Date logModified;

    /**
     * 
     */
	private String ext;
}