package pers.ecommerce.gulimall.ware.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 日志
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class UndoLogExcel {

    @Excel(name = "")
    private Long id;
    @Excel(name = "")
    private Long branchId;
    @Excel(name = "")
    private String xid;
    @Excel(name = "")
    private String context;
    @Excel(name = "")
    private Byte[] rollbackInfo;
    @Excel(name = "")
    private Integer logStatus;
    @Excel(name = "")
    private Date logCreated;
    @Excel(name = "")
    private Date logModified;
    @Excel(name = "")
    private String ext;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}