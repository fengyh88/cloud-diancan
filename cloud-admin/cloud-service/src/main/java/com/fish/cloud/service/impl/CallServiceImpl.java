package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fish.cloud.bean.model.Call;
import com.fish.cloud.repo.CallMapper;
import com.fish.cloud.service.ICallService;
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
	
}
