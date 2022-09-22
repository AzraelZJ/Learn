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
import pers.ecommerce.gulimall.common.utils.Result;
import pers.ecommerce.gulimall.common.validator.AssertUtils;
import pers.ecommerce.gulimall.common.validator.ValidatorUtils;
import pers.ecommerce.gulimall.common.validator.group.AddGroup;
import pers.ecommerce.gulimall.common.validator.group.DefaultGroup;
import pers.ecommerce.gulimall.common.validator.group.UpdateGroup;
import pers.ecommerce.gulimall.member.dto.GrowthChangeHistoryDTO;
import pers.ecommerce.gulimall.member.excel.GrowthChangeHistoryExcel;
import pers.ecommerce.gulimall.member.service.GrowthChangeHistoryService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("member/growthchangehistory")
@Api(tags = "成长值变化历史记录" )
public class GrowthChangeHistoryController {

    @Autowired
    private GrowthChangeHistoryService growthChangeHistoryService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int" ),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int" ),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String" ),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String" )
    })
    @RequiresPermissions("member:growthchangehistory:page")
    public Result<PageData<GrowthChangeHistoryDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<GrowthChangeHistoryDTO> page = growthChangeHistoryService.page(params);

        return new Result<PageData<GrowthChangeHistoryDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("member:growthchangehistory:info")
    public Result<GrowthChangeHistoryDTO> get(@PathVariable("id") Long id) {

            GrowthChangeHistoryDTO data = growthChangeHistoryService.get(id);

        return new Result<GrowthChangeHistoryDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("member:growthchangehistory:save")
    public Result save(@RequestBody GrowthChangeHistoryDTO dto) {

        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

            growthChangeHistoryService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("member:growthchangehistory:update")
    public Result update(@RequestBody GrowthChangeHistoryDTO dto) {

        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

            growthChangeHistoryService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("member:growthchangehistory:delete")
    public Result delete(@RequestBody Long[] ids) {

        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

            growthChangeHistoryService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("member:growthchangehistory:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {

        List<GrowthChangeHistoryDTO> list = growthChangeHistoryService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, GrowthChangeHistoryExcel.class);
    }
}