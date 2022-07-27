package pers.ecommerce.gulimall.member.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 会员收藏的专题活动
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@Data
public class MemberCollectSubjectExcel {

    @Excel(name = "id")
    private Long id;
    @Excel(name = "subject_id")
    private Long subjectId;
    @Excel(name = "subject名字")
    private String subjectName;
    @Excel(name = "subject图片")
    private String subjectImg;
    @Excel(name = "活动url")
    private String subjectUrl;
    @Excel(name = "记录创建者")
    private Long creator;
    @Excel(name = "记录创建时间")
    private Date createDate;
    @Excel(name = "记录修改时间")
    private Date updateDate;

}