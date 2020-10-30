package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.UserAddr;
import com.fish.cloud.bean.param.AddrAddParam;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.repo.UserAddrMapper;
import com.fish.cloud.service.IUserAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class UserAddrServiceImpl extends ServiceImpl<UserAddrMapper, UserAddr> implements IUserAddrService {

    @Override
    public TupleRet add(AddrAddParam addrAddParam) {
        return null;
    }

    @Override
    public Boolean updateStatus(Long id, Integer status) {
        UserAddr model = baseMapper.selectById(id);
        if (null == model){
            return true;
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return true;
    }

    @Override
    public TupleRet setDefault(long id) {
        UserAddr model = baseMapper.selectById(id);
        if (null == model){
            TupleRet.failed("收货地址不存在");
        }

        try {
//            List<UserAddr> models =baseMapper.selectList(new LambdaQueryWrapper<UserAddr>()
//            .eq(UserAddr::getUserId, model.getUserId())
//            .eq(UserAddr::getIsDefault,1));
//           baseMapper.u
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return TupleRet.failed("设置原来的默认地址为非默认地址失败");
        }

        model.setIsDefault(1);
        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return TupleRet.failed("设置默认收货地址失败失败");
        }

        return TupleRet.success();
    }
}
