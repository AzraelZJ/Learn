package pers.ecommerce.gulimall.product.controller;

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
import pers.ecommerce.gulimall.product.dto.BrandDTO;
import pers.ecommerce.gulimall.product.excel.BrandExcel;
import pers.ecommerce.gulimall.product.service.BrandService;
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
 * 品牌
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("product/brand")
@Api(tags = "品牌")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("product:brand:page")
    public Result<PageData<BrandDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<BrandDTO> page = brandService.page(params);

        return new Result<PageData<BrandDTO>>().ok(page);
    }

    @GetMapping("{brandId}")
    @ApiOperation("信息")
    @RequiresPermissions("product:brand:info")
    public Result<BrandDTO> get(@PathVariable("brandId") Long brandId) {

        BrandDTO data = brandService.get(brandId);

        return new Result<BrandDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("product:brand:save")
    public Result save(@RequestBody BrandDTO dto) {

        // 效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        brandService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("product:brand:update")
    public Result update(@RequestBody BrandDTO dto) {

        // 效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        brandService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("product:brand:delete")
    public Result delete(@RequestBody Long[] brandIds) {

        // 效验数据
        AssertUtils.isArrayEmpty(brandIds, "brandId");

        brandService.delete(brandIds);

        return new Result();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("product:brand:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {

        List<BrandDTO> list = brandService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, BrandExcel.class);
    }
}