package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fish.cloud.bean.dto.SysMenuDto;
import com.fish.cloud.bean.model.SysMenu;
import com.fish.cloud.bean.param.SysMenuAddParam;
import com.fish.cloud.bean.param.SysMenuEditParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.SysMenuMapper;
import com.fish.cloud.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    public List<SysMenuDto> listByMenuIdList(List<String> menuIdList) {
        List<SysMenu> models = this.list(new LambdaQueryWrapper<SysMenu>()
                .in(SysMenu::getMenuId, menuIdList)
                .eq(SysMenu::getStatus, 1)
                .orderByAsc(SysMenu::getSeq));
        var dtoList = toDtoList(models);
        return dtoList;
    }

    public List<SysMenuDto> listByMenuIdListAndMenuCate(List<String> menuIdList, Long menuCate) {
        List<SysMenu> models = this.list(new LambdaQueryWrapper<SysMenu>()
                .in(SysMenu::getMenuId, menuIdList)
                .eq(SysMenu::getStatus, 1)
                .eq(SysMenu::getMenuCate, menuCate)
                .orderByAsc(SysMenu::getSeq));
        var dtoList = toDtoList(models);
        return dtoList;
    }

    @Override
    public TupleRet status(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("菜单不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    @Override
    public TupleRet add(SysMenuAddParam sysMenuAddParam) {
        try {
            var model = new SysMenu();
            BeanUtils.copyProperties(sysMenuAddParam, model);
            model.setStatus(1);
            model.setCreatedBy(ApiContextHolder.getAuthDto().getEmpId());
            model.setCreatedTime(DateTimeUtil.getCurrentDateTime());
            baseMapper.insert(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed(e.getMessage());
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet edit(SysMenuEditParam sysMenuEditParam) {
        var model = new SysMenu();
        BeanUtils.copyProperties(sysMenuEditParam, model);
        model.setUpdateTime(DateTimeUtil.getCurrentDateTime());
        baseMapper.updateById(model);

        return TupleRet.success();
    }

    /**
     * 转成Dto列表
     *
     * @param sysMenuList
     * @return
     */
    private List<SysMenuDto> toDtoList(List<SysMenu> sysMenuList) {
        ArrayList<SysMenuDto> dtoList = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            // 如果是一级菜单才开始添加
            if (sysMenu.getMenuLevel() == 1) {
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
