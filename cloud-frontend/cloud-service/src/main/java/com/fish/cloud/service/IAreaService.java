package com.fish.cloud.service;

import com.fish.cloud.bean.model.Area;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 区域
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IAreaService extends IService<Area> {
    /**
     * 全部
     * @return
     */
    List<Area> all();
    /**
     * 省
     * @return
     */
    List<Area> province();

    /**
     * 市
     * @param pid
     * @return
     */
    List<Area> cityByPid(Long pid);

    /**
     * 区
     * @param pid
     * @return
     */
    List<Area> areaByPid(Long pid);
}
