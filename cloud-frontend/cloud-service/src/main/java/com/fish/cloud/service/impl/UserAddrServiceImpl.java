package com.fish.cloud.service.impl;

import com.fish.cloud.bean.model.UserAddr;
import com.fish.cloud.bean.param.UserAddrAddParam;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.common.util.DateTimeUtil;
import com.fish.cloud.repo.UserAddrMapper;
import com.fish.cloud.service.IUserAddrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 用户收货地址
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Slf4j
@Service
public class UserAddrServiceImpl extends ServiceImpl<UserAddrMapper, UserAddr> implements IUserAddrService {

    /**
     * 设为默认收货地址
     *
     * @param id
     * @return
     */
    @Override
    public TupleRet updateDefault(String id, String userId) {
        UserAddr model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            TupleRet.failed("收货地址不存在");
        }

        try {
            baseMapper.updateNotDefaultByUserId(userId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("设置非默认地址失败");
        }

        model.setIsDefault(1);
        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            log.error(e.getMessage());
            return TupleRet.failed("设置失败");
        }

        return TupleRet.success();
    }

    /**
     * 更新状态
     * @param id
     * @param status
     * @return
     */
    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        var model = baseMapper.selectById(id);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("该地址不存在");
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

    /**
     * 添加
     * @param userId
     * @param userAddrAddParam
     * @return
     */
    @Override
    public TupleRet add(String userId, UserAddrAddParam userAddrAddParam) {
        var model = new UserAddr();
        model.setUserId(userId);
        model.setReceiver(userAddrAddParam.getReceiver());
        model.setProvinceId(userAddrAddParam.getProvinceId());
        model.setProvince(userAddrAddParam.getProvince());
        model.setCityId(userAddrAddParam.getCityId());
        model.setCity(userAddrAddParam.getCity());
        model.setAreaId(userAddrAddParam.getAreaId());
        model.setArea(userAddrAddParam.getArea());
        model.setAddr(userAddrAddParam.getAddr());
        model.setMobile(userAddrAddParam.getMobile());
        model.setIsDefault(userAddrAddParam.getIsDefault());
        model.setStatus(1);
        model.setCreateTime(DateTimeUtil.getCurrentDateTime());

        // 如果新增的是默认地址，则设置其他的为非默认地址
        if (userAddrAddParam.getIsDefault() == 1){
            try {
                baseMapper.updateNotDefaultByUserId(userId);
            } catch (Exception e) {
                log.error(e.getMessage());
                return TupleRet.failed("设置非默认地址失败");
            }
        }

        try {
            baseMapper.insert(model);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            return TupleRet.failed("添加失败");
        }
        return TupleRet.success();
    }

    @Override
    public TupleRet edit(String userId, UserAddrAddParam userAddrAddParam) {
        var model = baseMapper.selectById(userAddrAddParam.getAddrId());
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("该地址不存在");
        }
        model.setReceiver(userAddrAddParam.getReceiver());
        model.setProvinceId(userAddrAddParam.getProvinceId());
        model.setProvince(userAddrAddParam.getProvince());
        model.setCityId(userAddrAddParam.getCityId());
        model.setCity(userAddrAddParam.getCity());
        model.setAreaId(userAddrAddParam.getAreaId());
        model.setArea(userAddrAddParam.getArea());
        model.setAddr(userAddrAddParam.getAddr());
        model.setMobile(userAddrAddParam.getMobile());
        model.setIsDefault(userAddrAddParam.getIsDefault());
        model.setStatus(1);
        model.setUpdateTime(DateTimeUtil.getCurrentDateTime());

        // 如果编辑为是默认地址，则设置其他的为非默认地址
        if (userAddrAddParam.getIsDefault() == 1){
            try {
                baseMapper.updateNotDefaultByUserId(userId);
            } catch (Exception e) {
                log.error(e.getMessage());
                return TupleRet.failed("设置非默认地址失败");
            }
        }

        try {
            baseMapper.updateById(model);
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            return TupleRet.failed("编辑失败");
        }
        return TupleRet.success();
    }

    @Override
    public TupleRet delete(String addrId) {
        var model = baseMapper.selectById(addrId);
        if (ObjectUtils.isEmpty(model)) {
            return TupleRet.failed("该地址不存在");
        }
        model.setStatus(0);
        baseMapper.updateById(model);
        return TupleRet.success();
    }

}
