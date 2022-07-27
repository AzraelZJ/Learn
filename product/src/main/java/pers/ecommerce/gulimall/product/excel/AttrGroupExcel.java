package pers.ecommerce.gulimall.product.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 属性分组
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class AttrGroupExcel {

    @Excel(name = "分组id")
    private Long attrGroupId;
    @Excel(name = "组名")
    private String attrGroupName;
    @Excel(name = "排序")
    private Integer sort;
    @Excel(name = "描述")
    private String descript;
    @Excel(name = "组图标")
    private String icon;
    @Excel(name = "所属分类id")
    private Long catelogId;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}