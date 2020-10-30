package com.fish.cloud.service;

import com.fish.cloud.bean.model.Duty;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.DutyAddParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 岗位
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IDutyService extends IService<Duty> {

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
     * @param dutyAddParam
     * @return
     */
    TupleRet add(String shopId, DutyAddParam dutyAddParam);
    /**
     * 编辑
     *
     * @param dutyAddParam
     * @return
     */
    TupleRet edit(String shopId, DutyAddParam dutyAddParam);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    Duty detail(Long id);

    /**
     * 所有列表
     *
     * @return
     */
    List<Duty> all(String shopId);
}
