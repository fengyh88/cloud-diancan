package com.fish.cloud.service;

import com.fish.cloud.bean.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.RoleAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IRoleService extends IService<Role> {
    /**
     * 更新状态，正常禁用删除
     *
     * @param id
     * @return
     */
    TupleRet status(Long id, Integer status);

    /**
     * 添加
     *
     * @param roleAddParam
     * @return
     */
    TupleRet add(RoleAddParam roleAddParam);
    /**
     * 编辑
     *
     * @param roleAddParam
     * @return
     */
    TupleRet edit(RoleAddParam roleAddParam);
}
