package pers.ecommerce.gulimall.member.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 积分变化历史记录
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class IntegrationChangeHistoryExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "member_id")
    private Long memberId;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "变化的值")
    private Integer changeCount;
    @Excel(name = "备注")
    private String note;
    @Excel(name = "来源：[0: 购物; 1: 管理员修改; 2: 活动]")
    private Integer sourceType;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}