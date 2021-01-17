package com.fish.cloud.service;

import com.fish.cloud.bean.dto.SysMenuDto;
import com.fish.cloud.bean.model.RoleMenu;
import com.fish.cloud.bean.model.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * @param menuClass 展示类别 0.数据展示平台 1.控制台
     * @return
     */
    public List<SysMenuDto> listByMenuIdListAndMenuClass(List<String> menuIdList, long menuClass);

}
