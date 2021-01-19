package com.fish.cloud.service;

import com.fish.cloud.bean.dto.TableDto;
import com.fish.cloud.bean.model.Table;
import com.baomidou.mybatisplus.extension.service.IService;
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
     * 全部
     * @return
     */
    List<TableDto> all();

    /**
     * 更新barcode
     * @return
     */
    TupleRet updateBarcode(Long tableId, String barcode);

    /**
     * 更新状态
     * @param tableId
     * @param status
     * @return
     */
    TupleRet status(Long tableId, Integer status);
}
