package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.MemGrade;
import com.fish.cloud.repo.MemGradeMapper;
import com.fish.cloud.service.IMemGradeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员等级
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class MemGradeServiceImpl extends ServiceImpl<MemGradeMapper, MemGrade> implements IMemGradeService {

    @Override
    public MemGrade detail(Long id) {
        var model = baseMapper.selectOne(new LambdaQueryWrapper<MemGrade>()
                .eq(MemGrade::getGradeId, id)
                .eq(MemGrade::getStatus, 1));
        return model;
    }
}
