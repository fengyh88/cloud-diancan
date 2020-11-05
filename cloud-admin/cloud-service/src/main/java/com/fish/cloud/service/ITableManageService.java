package com.fish.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.bean.param.TableAddParam;
import com.fish.cloud.bean.param.TableEditParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 台桌管理
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface ITableManageService extends IService<Table> {

    /**
     * 更新状态，1正常0禁用-1删除
     *
     * @param id
     * @return
     */
    TupleRet status(Long id, Integer status);

    /**
     * 添加
     *
     * @param sysDicAddParam
     * @return
     */
    TupleRet add(TableAddParam sysDicAddParam);

    /**
     * 编辑
     *
     * @param tableEditParam
     * @return
     */
    TupleRet edit(TableEditParam tableEditParam);
}
