/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package pers.ecommerce.gulimall.modules.sys.controller;

import pers.ecommerce.gulimall.common.annotation.LogOperation;
import pers.ecommerce.gulimall.common.constant.Constant;
import pers.ecommerce.gulimall.common.page.PageData;
import pers.ecommerce.gulimall.common.utils.Result;
import pers.ecommerce.gulimall.common.validator.AssertUtils;
import pers.ecommerce.gulimall.common.validator.ValidatorUtils;
import pers.ecommerce.gulimall.common.validator.group.DefaultGroup;
import pers.ecommerce.gulimall.common.validator.group.UpdateGroup;
import pers.ecommerce.gulimall.modules.sys.dto.SysDictDataDTO;
import pers.ecommerce.gulimall.modules.sys.service.SysDictDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * 字典数据
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("sys/dict/data")
@Api(tags="字典数据")
public class SysDictDataController {
    @Autowired
    private SysDictDataService sysDictDataService;

    @GetMapping("page")
    @ApiOperation("字典数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = Constant.PAGE, value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.LIMIT, value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
        @ApiImplicitParam(name = Constant.ORDER_FIELD, value = "排序字段", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = Constant.ORDER, value = "排序方式，可选值(asc、desc)", paramType = "query", dataType="String") ,
        @ApiImplicitParam(name = "dictLabel", value = "字典标签", paramType = "query", dataType="String"),
        @ApiImplicitParam(name = "dictValue", value = "字典值", paramType = "query", dataType="String")
    })
    @RequiresPermissions("sys:dict:page")
    public Result<PageData<SysDictDataDTO>> page(@ApiIgnore @RequestParam Map<String, Object> params){
        //字典类型
        PageData<SysDictDataDTO> page = sysDictDataService.page(params);

        return new Result<PageData<SysDictDataDTO>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:dict:info")
    public Result<SysDictDataDTO> get(@PathVariable("id") Long id){
        SysDictDataDTO data = sysDictDataService.get(id);

        return new Result<SysDictDataDTO>().ok(data);
    }

    @PostMapping
    @ApiOperation("保存")
    @LogOperation("保存")
    @RequiresPermissions("sys:dict:save")
    public Result save(@RequestBody SysDictDataDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, DefaultGroup.class);

        sysDictDataService.save(dto);

        return new Result();
    }

    @PutMapping
    @ApiOperation("修改")
    @LogOperation("修改")
    @RequiresPermissions("sys:dict:update")
    public Result update(@RequestBody SysDictDataDTO dto){
        //效验数据
        ValidatorUtils.validateEntity(dto, UpdateGroup.class, DefaultGroup.class);

        sysDictDataService.update(dto);

        return new Result();
    }

    @DeleteMapping
    @ApiOperation("删除")
    @LogOperation("删除")
    @RequiresPermissions("sys:dict:delete")
    public Result delete(@RequestBody Long[] ids){
        //效验数据
        AssertUtils.isArrayEmpty(ids, "id");

        sysDictDataService.delete(ids);

        return new Result();
    }

}