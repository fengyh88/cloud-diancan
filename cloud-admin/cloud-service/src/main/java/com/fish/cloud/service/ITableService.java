package com.fish.cloud.service;

import com.fish.cloud.bean.dto.TableDto;
import com.fish.cloud.bean.model.Table;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
