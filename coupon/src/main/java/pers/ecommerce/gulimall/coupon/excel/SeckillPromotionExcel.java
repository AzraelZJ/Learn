package pers.ecommerce.gulimall.coupon.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 秒杀活动
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class SeckillPromotionExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "活动标题")
    private String title;
    @Excel(name = "开始日期")
    private Date startTime;
    @Excel(name = "结束日期")
    private Date endTime;
    @Excel(name = "上下线状态")
    private Integer status;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "创建人")
    private Long userId;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}