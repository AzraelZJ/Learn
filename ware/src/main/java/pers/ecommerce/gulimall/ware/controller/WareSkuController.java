package pers.ecommerce.gulimall.ware.controller;

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
import pers.ecommerce.gulimall.ware.dto.WareSkuDTO;
import pers.ecommerce.gulimall.ware.excel.WareSkuExcel;
import pers.ecommerce.gulimall.ware.service.WareSkuService;
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
 * 商品库存
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("ware/waresku")
@Api(tags = "商品库存" )
public class WareSkuController {

    @Autowired
    private WareSkuService wareSkuService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int" ),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int" ),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String" ),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String" )
    })
    @RequiresPermissions("ware:waresku:page")
    public Result<PageData<WareSkuDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<WareSkuDTO> page = wareSkuService.page(params);

        return new Result<PageData<WareSkuDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("ware:waresku:info")
    public Result<WareSkuDTO> get(@PathVariable("id") Long id) {

            WareSkuDTO data = wareSkuService.get(id);

        return new Result<WareSkuDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("ware:waresku:save")
    public Result save(@RequestBody WareSkuDTO dto) {

        //效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

            wareSkuService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("ware:waresku:update")
    public Result update(@RequestBody WareSkuDTO dto) {

        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

            wareSkuService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("ware:waresku:delete")
    public Result delete(@RequestBody Long[] ids) {

        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

            wareSkuService.delete(ids);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("ware:waresku:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {

        List<WareSkuDTO> list = wareSkuService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, WareSkuExcel.class);
    }
}