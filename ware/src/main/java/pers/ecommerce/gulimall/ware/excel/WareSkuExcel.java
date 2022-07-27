package pers.ecommerce.gulimall.ware.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 商品库存
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class WareSkuExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "sku_id")
    private Long skuId;
    @Excel(name = "仓库id")
    private Long wareId;
    @Excel(name = "库存数")
    private Integer stock;
    @Excel(name = "sku_name")
    private String skuName;
    @Excel(name = "锁定库存")
    private Integer stockLocked;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}