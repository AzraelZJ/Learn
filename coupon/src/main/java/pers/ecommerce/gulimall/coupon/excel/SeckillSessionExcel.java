package pers.ecommerce.gulimall.coupon.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 秒杀活动场次
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class SeckillSessionExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "场次名称")
    private String name;
    @Excel(name = "每日开始时间")
    private Date startTime;
    @Excel(name = "每日结束时间")
    private Date endTime;
    @Excel(name = "启用状态")
    private Integer status;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}