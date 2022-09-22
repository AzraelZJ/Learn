package pers.ecommerce.gulimall.member.controller;

import pers.ecommerce.gulimall.common.annotation.LogOperation;
import pers.ecommerce.gulimall.common.constant.Constant;
import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.utils.ExcelUtils;
import pers.ecommerce.gulimall.common.utils.Result;
import pers.ecommerce.gulimall.common.validator.AssertUtils;
import pers.ecommerce.gulimall.common.validator.ValidatorUtils;
import pers.ecommerce.gulimall.common.validator.group.AddGroup;
import pers.ecommerce.gulimall.common.validator.group.DefaultGroup;
import pers.ecommerce.gulimall.common.validator.group.UpdateGroup;
import pers.ecommerce.gulimall.member.dto.MemberLoginLogDTO;
import pers.ecommerce.gulimall.member.excel.MemberLoginLogExcel;
import pers.ecommerce.gulimall.member.service.MemberLoginLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 会员登录记录
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("member/memberloginlog")
@Api(tags = "会员登录记录" )
public class MemberLoginLogController {

    @Autowired
    private MemberLoginLogService memberLoginLogService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int" ),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int" ),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String" ),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String" )
    })
    @RequiresPermissions("member:memberloginlog:page")
    public Result<PageData<MemberLoginLogDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<MemberLoginLogDTO> page = memberLoginLogService.page(params);

        return new Result<PageData<MemberLoginLogDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("member:memberloginlog:info")
    public Result<MemberLoginLogDTO> get(@PathVariable("id") Long id) {

            MemberLoginLogDTO data = memberLoginLogService.get(id);

        return new Result<MemberLoginLogDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("member:memberloginlog:save")
    public Result save(@RequestBody MemberLoginLogDTO dto) {

        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

            memberLoginLogService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("member:memberloginlog:update")
    public Result update(@RequestBody MemberLoginLogDTO dto) {

        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

            memberLoginLogService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("member:memberloginlog:delete")
    public Result delete(@RequestBody Long[] ids) {

        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

            memberLoginLogService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("member:memberloginlog:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {

        List<MemberLoginLogDTO> list = memberLoginLogService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, MemberLoginLogExcel.class);
    }
}