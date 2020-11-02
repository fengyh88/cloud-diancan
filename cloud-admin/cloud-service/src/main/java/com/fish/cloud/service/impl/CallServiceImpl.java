package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.repo.CallMapper;
import com.fish.cloud.service.ICallService;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 呼叫
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
public class CallServiceImpl extends ServiceImpl<CallMapper, Call> implements ICallService {
    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("记录不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }
}
