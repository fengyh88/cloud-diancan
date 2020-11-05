package com.fish.cloud.service;

import com.fish.cloud.bean.model.Table;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.TableAddParam;
import com.fish.cloud.bean.param.TableEditParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 台桌
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface ITableService extends IService<Table> {

    /**
     * 所有列表
     *
     * @return
     */
    List<Table> all();

    /**
     * 更新状态，10正常-1删除
     *
     * @param id
     * @return
     */
    TupleRet updateStatus(Long id, Integer status);

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
