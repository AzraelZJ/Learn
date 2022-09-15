package pers.ecommerce.gulimall.member.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.ecommerce.gulimall.common.annotation.LogOperation;
import pers.ecommerce.gulimall.common.constant.Constant;
import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.utils.ExcelUtils;
import pers.ecommerce.gulimall.common.utils.R;
import pers.ecommerce.gulimall.common.utils.Result;
import pers.ecommerce.gulimall.common.validator.AssertUtils;
import pers.ecommerce.gulimall.common.validator.ValidatorUtils;
import pers.ecommerce.gulimall.common.validator.group.AddGroup;
import pers.ecommerce.gulimall.common.validator.group.DefaultGroup;
import pers.ecommerce.gulimall.common.validator.group.UpdateGroup;
import pers.ecommerce.gulimall.member.dto.MemberDTO;
import pers.ecommerce.gulimall.member.entity.MemberEntity;
import pers.ecommerce.gulimall.member.excel.MemberExcel;
import pers.ecommerce.gulimall.member.feign.CouponFeignService;
import pers.ecommerce.gulimall.member.service.MemberService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 会员
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("member/member")
@Api(tags = "会员")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 注入远程接口
     */
    @Autowired
    CouponFeignService couponFeignService;

    /**
     * 获取当前会员的所有优惠券
     * @return R
     */
    @RequestMapping("coupons")
    public R test() {

        // 构造一个会员
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("AzraelZJ");

        R memberCoupons = couponFeignService.memberCoupons();

        return R.ok().put("member", memberEntity).put("coupons", memberCoupons.get("coupons"));
    }

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("member:member:page")
    public Result<PageData<MemberDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<MemberDTO> page = memberService.page(params);

        return new Result<PageData<MemberDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("member:member:info")
    public Result<MemberDTO> get(@PathVariable("id") Long id) {

        MemberDTO data = memberService.getAttr(id);

        return new Result<MemberDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("member:member:save")
    public <T> Result<T> save(@RequestBody MemberDTO dto) {

        // 效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        memberService.save(dto);

        return new Result<>();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("member:member:update")
    public <T> Result<T> update(@RequestBody MemberDTO dto) {

        // 效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        memberService.update(dto);

        return new Result<>();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("member:member:delete")
    public <T> Result<T> delete(@RequestBody Long[] ids) {

        // 效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        memberService.delete(ids);

        return new Result<>();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("member:member:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {

        List<MemberDTO> list = memberService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, MemberExcel.class);
    }
}