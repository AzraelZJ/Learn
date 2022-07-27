package pers.ecommerce.gulimall.coupon.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品阶梯价格
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class SkuLadderExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "spu_id")
    private Long skuId;
    @Excel(name = "满几件享受优惠")
    private Integer fullCount;
    @Excel(name = "折扣")
    private BigDecimal discount;
    @Excel(name = "折后价")
    private BigDecimal price;
    @Excel(name = "是否叠加其他优惠：[0: 不可叠加; 1: 可叠加]")
    private Integer addOther;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}