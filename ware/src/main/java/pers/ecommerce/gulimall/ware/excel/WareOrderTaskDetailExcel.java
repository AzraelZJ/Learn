package pers.ecommerce.gulimall.ware.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 库存工作单详细信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class WareOrderTaskDetailExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "sku_id")
    private Long skuId;
    @Excel(name = "sku_name")
    private String skuName;
    @Excel(name = "购买个数")
    private Integer skuNum;
    @Excel(name = "工作单id")
    private Long taskId;
    @Excel(name = "仓库id")
    private Long wareId;
    @Excel(name = "锁定状态：[1: 已锁定; 2: 已解锁; 3: 扣减]")
    private Integer lockStatus;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}