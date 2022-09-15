package pers.ecommerce.gulimall.product.controller;

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
import pers.ecommerce.gulimall.product.dto.AttrDTO;
import pers.ecommerce.gulimall.product.excel.AttrExcel;
import pers.ecommerce.gulimall.product.service.AttrService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("product/attr")
@Api(tags = "商品属性")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("product:attr:page")
    public Result<PageData<AttrDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<AttrDTO> page = attrService.page(params);
        System.out.println(page);

        return new Result<PageData<AttrDTO>>().ok(page);
    }

    @GetMapping("fuzzyquery/{catId}")
    @ApiOperation("分页模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("product:attr:page")
    public Result<PageData<AttrDTO>> fuzzyQuery(
            @ApiIgnore @RequestParam Map<String, Object> params,
            @PathVariable("catId") Long catId) {

        PageData<AttrDTO> fuzzyQueryPage = attrService.fuzzyQuery(params, catId);

        return new Result<PageData<AttrDTO>>().ok(fuzzyQueryPage);
    }

    @GetMapping("{attrId}")
    @ApiOperation("信息")
    @RequiresPermissions("product:attr:info")
    public Result<AttrDTO> get(@PathVariable("attrId") Long attrId) {

        AttrDTO data = attrService.getAttr(attrId);

        return new Result<AttrDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("product:attr:save")
    public Result<AttrDTO> save(@RequestBody AttrDTO dto) {

        // 效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        attrService.saveAttr(dto);

        return new Result<>();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("product:attr:update")
    public Result<AttrDTO> update(@RequestBody AttrDTO attrDTO) {

        // 效验数据
        ValidatorUtils.validateEntity(attrDTO, UpdateGroup.class, DefaultGroup.class);

        attrService.updateAttr(attrDTO);
        System.out.println(attrDTO);

        return new Result<>();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("product:attr:delete")
    public Result<Long[]> delete(@RequestBody Long[] ids) {

        // 效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        attrService.delete(ids);

        return new Result<>();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("product:attr:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {

        List<AttrDTO> list = attrService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, AttrExcel.class);
    }
}