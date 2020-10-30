package com.fish.cloud.api.controller;

import com.fish.cloud.bean.model.Area;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  区域
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Api(tags = "区域")
@RestController
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private IAreaService areaService;

    @ApiOperation("全部")
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ApiResult<List<Area>> all() {
        var dtos = areaService.all();
        return ApiResult.success(dtos);
    }

    @ApiOperation("省")
    @RequestMapping(value = "/province",method = RequestMethod.GET)
    public ApiResult<List<Area>> province() {
        var dtos = areaService.province();
        return ApiResult.success(dtos);
    }

    @ApiOperation("市")
    @ApiImplicitParam(name = "pid", value = "父Id", required = true)
    @RequestMapping(value = "/cityByPid",method = RequestMethod.GET)
    public ApiResult<List<Area>> cityByPid(Long pid) {
        var dtos = areaService.cityByPid(pid);
        return ApiResult.success(dtos);
    }

    @ApiOperation("区")
    @ApiImplicitParam(name = "pid", value = "父Id", required = true)
    @RequestMapping(value = "/areaByPid",method = RequestMethod.GET)
    public ApiResult<List<Area>> areaByPid(Long pid) {
        var dtos = areaService.areaByPid(pid);
        return ApiResult.success(dtos);
    }
}
