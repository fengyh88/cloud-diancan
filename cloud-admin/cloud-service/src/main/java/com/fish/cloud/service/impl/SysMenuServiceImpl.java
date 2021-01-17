package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.SysMenuDto;
import com.fish.cloud.bean.model.RoleMenu;
import com.fish.cloud.bean.model.SysMenu;
import com.fish.cloud.repo.SysMenuMapper;
import com.fish.cloud.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    public List<SysMenuDto> listByMenuIdList(List<String> menuIdList) {
        List<SysMenu> models = this.list(new LambdaQueryWrapper<SysMenu>()
                .in(SysMenu::getMenuId, menuIdList)
                .eq(SysMenu::getShowType, 1)
                .orderByAsc(SysMenu::getSeq));
        var dtoList = toDtoList(models);
        return dtoList;
    }

    public List<SysMenuDto> listByMenuIdListAndMenuClass(List<String> menuIdList, long menuClass) {
        List<SysMenu> models = this.list(new LambdaQueryWrapper<SysMenu>()
                .in(SysMenu::getMenuId, menuIdList)
                .eq(SysMenu::getShowType, 1)
                .eq(SysMenu::getMenuClass, menuClass)
                .orderByAsc(SysMenu::getSeq));
        var dtoList = toDtoList(models);
        return dtoList;
    }

    /**
     * 转成Dto列表
     *
     * @param sysMenuList
     * @return
     */
    private List<SysMenuDto> toDtoList(List<SysMenu> sysMenuList) {
        // entity 转 dto
        ArrayList<SysMenuDto> dtoList = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            // 如果是一级菜单才开始添加
            if (sysMenu.getMenuType() == 1) {
                SysMenuDto dto = new SysMenuDto();
                BeanUtils.copyProperties(sysMenu, dto);

                // 获取当前菜单的二级菜单
                List<SysMenuDto> secondDtoList = sysMenuList.stream().filter(model -> model.getPId() != null && model.getPId().equals(dto.getMenuId())).map(model1 -> {
                    SysMenuDto dtoSecond = new SysMenuDto();
                    BeanUtils.copyProperties(model1, dtoSecond);
                    return dtoSecond;
                }).collect(Collectors.toList());
                dto.setSubs(secondDtoList);

                dtoList.add(dto);
            }
        }
        return dtoList;
    }
}
