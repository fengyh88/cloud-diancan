package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.dto.UserDto;
import com.fish.cloud.bean.model.User;
import com.fish.cloud.bean.param.UserMobileParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.UserMapper;
import com.fish.cloud.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public TupleRet mobile(UserMobileParam userMobileParam) {
        var model = baseMapper.selectById(userMobileParam.getUserId());
        if (ObjectUtils.isEmpty(model)){
            return TupleRet.failed("用户不存在");
        }
        var count = baseMapper.selectCount(new LambdaQueryWrapper<User>()
                .eq(User::getMobile,userMobileParam.getMobile())
                .ne(User::getUserId, userMobileParam.getUserId()));
        if (count > 0) {
            return TupleRet.failed("手机号已注册");
        }

        try {
            model.setMobile(userMobileParam.getMobile());
            model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

            baseMapper.updateById(model);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public UserDto detail(String id) {
        return baseMapper.detail(id);
    }
}
