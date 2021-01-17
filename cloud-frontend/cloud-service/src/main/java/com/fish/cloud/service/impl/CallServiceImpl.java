package com.fish.cloud.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.dto.CallDto;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.bean.param.CallAddParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.CallMapper;
import com.fish.cloud.service.ICallService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 呼叫
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Service
@Slf4j
public class CallServiceImpl extends ServiceImpl<CallMapper, Call> implements ICallService {

    @Override
    public TupleRet add(CallAddParam callAddParam) {
        var model = new Call();
        BeanUtil.copyProperties(callAddParam, model);
        model.setStatus(1);
        model.setCreateTime(DateTimeUtil.getCurrentDateTime());

        try {
            baseMapper.insert(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }

        return TupleRet.success();
    }

    @Override
    public List<Call> listByTableCode(String tableCode) {
        var models = baseMapper.selectList(new LambdaQueryWrapper<Call>()
                .eq(Call::getShopId, ApiContextHolder.getShopId())
                .eq(Call::getTableId, ApiContextHolder.getAuthTableDto().getTableId())
                .ne(Call::getStatus, 0)); // 0表示未过期的
        return models;
    }

}
