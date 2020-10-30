package com.fish.cloud.service;

import com.fish.cloud.bean.dto.EmpDto;
import com.fish.cloud.bean.model.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.LoginParam;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IEmpService extends IService<Emp> {

    /**
     * 更新状态，正常禁用删除
     *
     * @param id
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

    /**
     * 添加
     *
     * @param empAddParam
     * @return
     */
    TupleRet add(String shopId, EmpAddParam empAddParam);
    /**
     * 编辑
     *
     * @param empAddParam
     * @return
     */
    TupleRet edit(String shopId, EmpAddParam empAddParam);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    EmpDto detail(Long id);

    /**
     * 所有列表
     *
     * @return
     */
    List<EmpDto> all(String shopId);
}
