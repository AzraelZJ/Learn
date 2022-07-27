package pers.ecommerce.gulimall.member.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 会员登录记录
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class MemberLoginLogExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "会员id")
    private Long memberId;
    @Excel(name = "创建时间")
    private Date createTime;
    @Excel(name = "ip地址")
    private String ip;
    @Excel(name = "城市")
    private String city;
    @Excel(name = "登录类型：[1: web; 2: App]")
    private Integer loginType;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}