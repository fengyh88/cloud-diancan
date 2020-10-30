package com.fish.cloud.service;

import com.fish.cloud.bean.model.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.AdminLoginParam;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.common.util.TupleRet;

/**
 * <p>
 * 员工 服务类
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IEmpService extends IService<Emp> {

    /**
     * 登录
     *
     * @param adminLoginParam
     * @return
     */
    public TupleRet login(AdminLoginParam adminLoginParam);

    /**
     * 更新密码
     *
     * @param empPwdParam
     * @return
     */
    public TupleRet updatePassword(EmpPwdParam empPwdParam);

    /**
     * 更新头像
     *
     * @param avatarUrl
     * @return
     */
    public TupleRet updateAvatarUrl(String avatarUrl, Long empId);

    /**
     * 更新状态
     *
     * @param id
     * @return
     */
    public TupleRet updateStatus(Long id, Integer status);

    /**
     * 增加或修改用户
     *
     * @param empAddParam
     * @return
     */
    public TupleRet addOrEdit(EmpAddParam empAddParam);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    public TupleRet detail(Long id);

    /**
     * 所有列表
     *
     * @return
     */
    public TupleRet all();
}
