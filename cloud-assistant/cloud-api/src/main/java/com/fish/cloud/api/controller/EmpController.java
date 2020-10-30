package com.fish.cloud.api.controller;

import cn.hutool.core.lang.Tuple;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.service.IEmpService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@RestController
@RequestMapping("/api/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;

    @ApiOperation("更新密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public TupleRet updatePassword(@RequestBody EmpPwdParam empPwdParam) {
        return empService.updatePassword(empPwdParam);
    }

    @ApiOperation("更新头像")
    @RequestMapping(value = "/updateAvatarUrl", method = RequestMethod.POST)
    public TupleRet updateAvatarUrl(@RequestBody String avatarUrl,Long empId) {
        return empService.updateAvatarUrl(avatarUrl,empId);
    }

    @ApiOperation("更改状态")
    @GetMapping(value = "/updateStatus")
    public TupleRet updateStatus(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        if (!ArrayUtils.contains(new int[]{0, 1}, status)) {
            return TupleRet.failed("需传入0 启用 1禁用");
        }
        return empService.updateStatus(id, status);
    }

    @ApiOperation("修改个人信息")
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    public TupleRet addOrEdit(@RequestBody EmpAddParam empAddParam) {
        return empService.addOrEdit(empAddParam);
    }

    @ApiOperation("详情")
    @GetMapping(value = "/detail")
    public TupleRet detail(@RequestParam(value = "id") long id) {
        return empService.detail(id);
    }

    @ApiOperation("所有列表")
    @GetMapping(value = "/all")
    public TupleRet<List<Emp>> all() {
        return empService.all();
    }
}
