package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.Area;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.repo.SysAreaMapper;
import com.fish.cloud.service.IAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 区域
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class AreaServiceImpl extends ServiceImpl<SysAreaMapper, Area> implements IAreaService {


    @Override
    public List<Area> all() {
        var models = baseMapper.selectList(new LambdaQueryWrapper<>());
        return models;
    }

    @Override
    public List<Area> province() {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Area>()
                .eq(Area::getPId, 0)
                .eq(Area::getGrade, 1));
        return models;
    }

    @Override
    public List<Area> cityByPid(Long pid) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Area>()
                .eq(Area::getPId, pid)
                .eq(Area::getGrade, 2));
        return models;
    }

    @Override
    public List<Area> areaByPid(Long pid) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Area>()
                .eq(Area::getPId, pid)
                .eq(Area::getGrade, 3));
        return models;
    }
}
