package com.fish.cloud.service;

import com.fish.cloud.bean.model.MemGrade;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员等级
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
public interface IMemGradeService extends IService<MemGrade> {
    /**
     * 详情
     *
     * @param id
     * @return
     */
    MemGrade detail(Long id);
}
