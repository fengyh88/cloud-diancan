package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.model.Role;
import com.fish.cloud.bean.param.RoleAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.RoleMapper;
import com.fish.cloud.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> all() {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Role>()
                .eq(Role::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .ne(Role::getStatus, -1));
        return models;
    }

    /**
     * 更新状态，正常禁用删除
     * @param id
     * @param status
     * @return
     */
    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("角色不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(RoleAddParam roleAddParam) {
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Role>()
                .eq(Role::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Role::getRoleCode, roleAddParam.getRoleCode())
                .eq(Role::getStatus, 1));
        if (count > 0) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            var model = new Role();
            model.setRoleCode(roleAddParam.getRoleCode());
            model.setRoleName(roleAddParam.getRoleName());
            model.setShopId(ApiContextHolder.getAuthDto().getShopId());
            model.setRemark(roleAddParam.getRemark());
            model.setStatus(1);
            model.setCreateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public TupleRet edit(RoleAddParam roleAddParam) {
        var model = baseMapper.selectById(roleAddParam.getRoleId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("角色不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<Role>()
                .eq(Role::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(Role::getRoleCode, roleAddParam.getRoleCode())
                .ne(Role::getRoleId, model.getRoleId())
                .eq(Role::getStatus, 1));
        if (count > 0) {
            return TupleRet.failed("编码不得重复");
        }

        try {
            model.setRoleCode(roleAddParam.getRoleCode());
            model.setRoleName(roleAddParam.getRoleName());
            model.setRemark(roleAddParam.getRemark());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }
}