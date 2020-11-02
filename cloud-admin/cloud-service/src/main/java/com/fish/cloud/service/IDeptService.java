package com.fish.cloud.service;

import com.fish.cloud.bean.model.Dept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.DeptAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 部门
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface IDeptService extends IService<Dept> {
    /**
     * 更新状态，1正常 0禁用 -1删除
     *
     * @param id
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);
    /**
     * 添加
     *
     * @param deptAddParam
     * @return
     */
    TupleRet add(DeptAddParam deptAddParam);
    /**
     * 编辑
     *
     * @param deptAddParam
     * @return
     */
    TupleRet edit(DeptAddParam deptAddParam);
}
