package pers.ecommerce.gulimall.ware.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 仓库信息
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class WareInfoExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "仓库名")
    private String name;
    @Excel(name = "仓库地址")
    private String address;
    @Excel(name = "区域编码")
    private String areacode;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}