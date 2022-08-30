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
import pers.ecommerce.gulimall.product.dto.CategoryDTO;
import pers.ecommerce.gulimall.product.entity.CategoryEntity;
import pers.ecommerce.gulimall.product.excel.CategoryExcel;
import pers.ecommerce.gulimall.product.service.CategoryService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author AzraelZJ 929780652@qq.com
 * @since 1.0.0 2022-07-13
 */
@RestController
@RequestMapping("product/category")
@Api(tags = "商品三级分类")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     *
     * @return 结果
     */
    @RequestMapping("list")
    @RequiresPermissions("product:category:list")
    public Result<List<CategoryDTO>> list() {

        // TODO 将list请求整合到page内，并添加分页实现
        List<CategoryDTO> categoryDTOList = categoryService.listWithTree();

        return new Result<List<CategoryDTO>>().ok(categoryDTOList);
    }

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
    })
    @RequiresPermissions("product:category:page")
    public Result<PageData<CategoryDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params) {

        PageData<CategoryDTO> page = categoryService.page(params);

        return new Result<PageData<CategoryDTO>>().ok(page);
    }

    @GetMapping("{catId}")
    @ApiOperation("信息")
    @RequiresPermissions("product:category:info")
    public Result<CategoryDTO> get(@PathVariable("catId") Long catId) {

        CategoryDTO data = categoryService.get(catId);

        return new Result<CategoryDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("product:category:save")
    public Result<CategoryDTO> save(@RequestBody CategoryDTO dto) {

        // 效验数据
        ValidatorUtils.validateEntity(dto, AddGroup.class, DefaultGroup.class);

        categoryService.save(dto);

        return new Result<>();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("product:category:update")
    public Result<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO) {

        // 效验数据
        ValidatorUtils.validateEntity(categoryDTO, UpdateGroup.class, DefaultGroup.class);

        categoryService.update(categoryDTO);

        return new Result<>();
    }

    @PutMapping("/update/sort")
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("product:category:updte")
    public Result<CategoryDTO> update(@RequestBody CategoryEntity[] categoryEntityList) {

        // 效验数据
        ValidatorUtils.validateEntity(categoryEntityList, UpdateGroup.class, DefaultGroup.class);

        categoryService.updateBatchById(List.of(categoryEntityList));

        return new Result<>();
    }

    /**
     * 删除商品目录项，必须发送 DELETE 类型的请求，@RequestBody：获取请求体
     * SpringMVC 会自动将请求体内的数据（JSON）转为相应的对象
     *
     * @param catIds 商品目录项 id 数组
     * @return 响应结果
     */
    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("product:category:delete")
    public Result<Long[]> delete(@RequestBody Long[] catIds) {

        // 效验数据
        AssertUtils.isArrayEmpty(catIds, "catIds");

        categoryService.delete(catIds);

        return new Result<>();
    }

    @GetMapping("export")
    @ApiOperation("导出")
    @LogOperation("导出")
    @RequiresPermissions("product:category:export")
    public void export(@ApiIgnore @RequestParam Map<String, Object> params, HttpServletResponse response) throws Exception {

        List<CategoryDTO> list = categoryService.list(params);

        ExcelUtils.exportExcelToTarget(response, null, list, CategoryExcel.class);
    }
}