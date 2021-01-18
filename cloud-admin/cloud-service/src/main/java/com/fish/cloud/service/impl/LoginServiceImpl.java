package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.LoginDto;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.token.AuthDto;
import com.fish.cloud.common.token.JwtUtil;
import com.fish.cloud.common.util.MD5Util;
import com.fish.cloud.service.*;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 登录
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private IShopService shopService;
    @Autowired
    private IEmpService empService;
    @Autowired
    private IRoleMenuService roleMenuService;
    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 登录
     * @param loginParam
     * @return
     */
    @Override
    public TupleRet<LoginDto> token(LoginParam loginParam) {
        // 判断店铺是否存在
        var shop = shopService.getById(loginParam.getShopId());
        if (ObjectUtils.isEmpty(shop)) {
            return TupleRet.failed("店铺不存在");
        }

        // 判断员工是否存在
        LambdaQueryWrapper<Emp> queryWrapper = new LambdaQueryWrapper<Emp>()
                .eq(Emp::getShopId, loginParam.getShopId())
                .and(wrapper -> {
                    wrapper.eq(Emp::getEmpNumber, loginParam.getUserNumber())
                            .or()
                            .eq(Emp::getMobile, loginParam.getUserNumber());
                    return wrapper;
                })
                .eq(Emp::getStatus, 1);
        var emp = empService.getOne(queryWrapper);
        if (ObjectUtils.isEmpty(emp)) {
            return TupleRet.failed("用户不存在");
        }

        if (!MD5Util.authenticatePassword(emp.getPassword(), loginParam.getPassword())) {
            return TupleRet.failed("密码不正确");
        }

        // 生成token
        AuthDto authDto = new AuthDto(emp.getEmpId(), shop.getShopId());
        String token = JwtUtil.toToken(authDto);
        // 缓存CONTEXT
        ApiContextHolder.setAuthDto(authDto);

        // 获取菜单列表
        var menuIdList = roleMenuService.listMenuIdByRoleId(emp.getRoleId());
        var sysMenuDtoList = sysMenuService.listByMenuIdListAndMenuCate(menuIdList, 1);

        // 组装返回
        LoginDto loginDto = new LoginDto();
        loginDto.setToken(token);
        loginDto.setRoleId(emp.getRoleId());
        loginDto.setEmpName(emp.getEmpName());
        loginDto.setMenuList(sysMenuDtoList);

        return TupleRet.success(loginDto);
    }
}
