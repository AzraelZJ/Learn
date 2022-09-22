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
import pers.ecommerce.gulimall.product.dto.AttrAttrgroupRelationDTO;
import pers.ecommerce.gulimall.product.dto.AttrDTO;
import pers.ecommerce.gulimall.product.excel.AttrAttrgroupRelationExcel;
import pers.ecommerce.gulimall.product.service.AttrAttrgroupRelationService;
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
 * 属性&属性分组关联
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("product/attrattrgrouprelation")
@Api(tags = "属性&属性分组关联")
public class AttrAttrgroupRelationController {

    @Autowired
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    /**
     * 按照attrGroupId分页查询已关联的Attr
     *
     * @param params 参数
     * @return 分页结果
     */
    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("product:attrattrgrouprelation:page")
    public Result<PageData<AttrAttrgroupRelationDTO>> pageByAttrGroupId(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<AttrAttrgroupRelationDTO> page = attrAttrgroupRelationService.pageByAttrGroupId(params);

        return new Result<PageData<AttrAttrgroupRelationDTO>>().ok(page);
    }

    /**
     * 按照attrGroupId分页查询未关联的Attr
     *
     * @param params 参数
     * @return 分页结果
     */
    @GetMapping("/unrelatedattr/page")
    @ApiOperation("分页查询未分组的属性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("product:attrattrgrouprelation:page")
    public Result<PageData<AttrAttrgroupRelationDTO>> pageUnrelatedAttr(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<AttrAttrgroupRelationDTO> page = attrAttrgroupRelationService.pageUnrelatedAttr(params);

        return new Result<PageData<AttrAttrgroupRelationDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("product:attrattrgrouprelation:info")
    public Result<List<AttrDTO>> get(@PathVariable("id") Long id) {

        List<AttrDTO> attrDTOList = attrAttrgroupRelationService.getAttr(id);

        return new Result<List<AttrDTO>>().ok(attrDTOList);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("product:attrattrgrouprelation:save")
    public Result<AttrAttrgroupRelationDTO> save(@RequestBody AttrAttrgroupRelationDTO dto) {

        // 效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        attrAttrgroupRelationService.save(dto);

        return new Result<>();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("product:attrattrgrouprelation:update")
    public Result<AttrAttrgroupRelationDTO> update(@RequestBody AttrAttrgroupRelationDTO dto) {

        // 效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        attrAttrgroupRelationService.update(dto);

        return new Result<>();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("product:attrattrgrouprelation:delete")
    public Result<Long[]> delete(@RequestBody Long[] ids) {

        // 效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        attrAttrgroupRelationService.delete(ids);

        return new Result<>();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("product:attrattrgrouprelation:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {

        List<AttrAttrgroupRelationDTO> list = attrAttrgroupRelationService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, AttrAttrgroupRelationExcel.class);
    }
}