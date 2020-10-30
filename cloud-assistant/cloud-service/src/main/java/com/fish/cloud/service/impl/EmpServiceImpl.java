package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fish.cloud.bean.model.Emp;
import com.fish.cloud.bean.param.AdminLoginParam;
import com.fish.cloud.bean.param.EmpAddParam;
import com.fish.cloud.bean.param.EmpPwdParam;
import com.fish.cloud.common.util.MD5Util;
import com.fish.cloud.common.util.SecurityUtil;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.repo.EmpMapper;
import com.fish.cloud.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.service.IShopService;
import lombok.var;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

    @Autowired
    private IShopService shopService;

    @Override
    public TupleRet login(AdminLoginParam adminLoginParam) {
        var emp = baseMapper.selectOne(new LambdaQueryWrapper<Emp>()
                .eq(Emp::getEmpNumber, adminLoginParam.getUserNumber()));

        if (null == emp) {
            return TupleRet.failed("用户不存在");
        }
        if (!MD5Util.authenticatePassword(emp.getPassword(), adminLoginParam.getPassword())) {
            return TupleRet.failed("密码不正确");
        }

        return TupleRet.success(emp);
    }

    @Override
    public TupleRet updatePassword(EmpPwdParam empPwdParam) {
        Emp model = baseMapper.selectById(SecurityUtil.getAdmin().getEmpId());
        if (null == model) {
            return TupleRet.failed("用户不存在");
        }
        if(!model.getPassword().equals(MD5Util.md5(empPwdParam.getOldPwd()))) {
            return TupleRet.failed("原密码错误");
        }
        if (!empPwdParam.getNewPwd().equals(empPwdParam.getNewPwd2())) {
            return TupleRet.failed("两次密码输入不一致");
        }
        model.setPassword(MD5Util.md5(empPwdParam.getNewPwd()));

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            // logger.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet updateAvatarUrl(String avatarUrl, Long empId) {
        Emp model = baseMapper.selectById(SecurityUtil.getAdmin().getEmpId());
        if (null == model) {
            return TupleRet.failed("用户不存在");
        }
        if (!avatarUrl.startsWith("OTA")) {
            avatarUrl = avatarUrl.substring(avatarUrl.indexOf("OTA"));
        }
        model.setPic(avatarUrl);

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
            // logger.error(e.getMessage());
            return TupleRet.failed("更新失败");
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet updateStatus(Long id, Integer status) {
        return null;
    }

    @Override
    public TupleRet addOrEdit(EmpAddParam empAddParam) {
        try {
            Emp existModel = baseMapper.selectById(empAddParam.getEmpId());
            if (null == existModel) {
                //不存在，则新增
//            AdminModel adminModelUserCode = adminRepository.findFirstByStoreIdAndUserCode(authDto.getStoreId(), empAddParam.getUserCode());
//            if (adminModelUserCode != null && adminModelUserCode.getStatus() != 3) {
//                return null;
//            }
                Emp model = new Emp();
                model.setShopId(SecurityUtil.getAdmin().getShopId());
                model.setEmpId(empAddParam.getEmpId());
                model.setEmpName(empAddParam.getEmpName());
                model.setPassword(MD5Util.md5("111111"));
                model.setGender(empAddParam.getGender());
                model.setBirthDate(empAddParam.getBirthDate());
                model.setMobile(empAddParam.getMobile());
                model.setStatus(empAddParam.getStatus());
                String avatarUrl = empAddParam.getPic();
                if (!avatarUrl.startsWith("OTA")) {
                    avatarUrl = avatarUrl.substring(avatarUrl.indexOf("OTA"));
                }
                model.setPic(avatarUrl);

                baseMapper.insert(model);
            }
            //已存在，则编辑
//        //1 UserCode不得重复
//        AdminModel adminModelUserCode = adminRepository.findFirstByStoreIdAndUserCode(authDto.getStoreId(), empAddParam.getUserCode());
//        if (adminModelUserCode != null && adminModelUserCode.getStatus() != 3 && adminModelUserCode.getId() != empAddParam.getId()) {
//            return null;
//        }
            else {
                existModel.setEmpName(empAddParam.getEmpName());
                existModel.setPassword(MD5Util.md5("111111"));
                existModel.setGender(empAddParam.getGender());
                existModel.setBirthDate(empAddParam.getBirthDate());
                existModel.setMobile(empAddParam.getMobile());
                existModel.setStatus(empAddParam.getStatus());
                String avatarUrl = empAddParam.getPic();
                if (!avatarUrl.startsWith("OTA")) {
                    avatarUrl = avatarUrl.substring(avatarUrl.indexOf("OTA"));
                }
                existModel.setPic(avatarUrl);
                existModel.setStatus(empAddParam.getStatus());

                baseMapper.updateById(existModel);
            }
        } catch (Exception ex) {
            // logger.error(ex.getStackTrace());
            return TupleRet.failed(ex.getMessage());
        }
        return TupleRet.success();
    }

    @Override
    public TupleRet detail(Long id) {
        return null;
    }

    @Override
    public TupleRet all() {
        return null;
    }

}
