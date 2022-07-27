package pers.ecommerce.gulimall.ware.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 采购详细信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class PurchaseDetailExcel {

    @Excel(name = "")
    private Long id;
    @Excel(name = "采购单id")
    private Long purchaseId;
    @Excel(name = "采购商品id")
    private Long skuId;
    @Excel(name = "采购数量")
    private Integer skuNum;
    @Excel(name = "采购金额")
    private BigDecimal skuPrice;
    @Excel(name = "仓库id")
    private Long wareId;
    @Excel(name = "状态：[0: 新建; 1: 已分配; 2: 正在采购; 3: 已完成，4: 采购失败]")
    private Integer status;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}