package com.fish.cloud.service;

import com.fish.cloud.bean.dto.SysMenuDto;
import com.fish.cloud.bean.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fish.cloud.bean.param.SysMenuAddParam;
import com.fish.cloud.bean.param.SysMenuEditParam;
import com.fish.cloud.common.ret.TupleRet;

import java.util.List;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 根据菜单Id列表获取列表
     *
     * @param menuIdList
     * @return
     */
    List<SysMenuDto> listByMenuIdList(List<String> menuIdList);

    /**
     * 根据菜单Id列表和展示类别获取列表
     *
     * @param menuIdList     权限下菜单列表
     * @param menuCate 展示类别 0.数据展示平台 1.控制台
     * @return
     */
    List<SysMenuDto> listByMenuIdListAndMenuCate(List<String> menuIdList, Long menuCate);

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
     * @param sysMenuAddParam
     * @return
     */
    TupleRet add(SysMenuAddParam sysMenuAddParam);
    /**
     * 编辑
     *
     * @param sysMenuEditParam
     * @return
     */
    TupleRet edit(SysMenuEditParam sysMenuEditParam);

}
