package com.fish.cloud.api.task;

import cn.hutool.core.collection.CollectionUtil;
import com.fish.cloud.api.config.ConfigBeanValue;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.common.ret.TupleRet;
import com.fish.cloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class OrderTask {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ConfigBeanValue configBeanValue;

    @Scheduled(initialDelay =  1000 * 10,fixedDelay = 1000 * 60 * 10)
    public void cancelOrder(){
        if (configBeanValue.isDev){
            log.info("取消超时未支付订单");
            return;
        }
        // 获取30分钟之前未支付的订单
        List<Order> orders = orderService.listNotPayForMin(30);
        if (CollectionUtil.isEmpty(orders)) {
            return;
        }

        // 自动取消订单
        try {
            orders.forEach(order -> {
               TupleRet ret = orderService.cancel(order);
               if (!ret.getSuccess()){
                   log.error(ret.getMessage());
               }
            });

        } catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * 确认收货
     */
    @Scheduled(initialDelay =  1000 * 10,fixedDelay = 1000 * 1 * 24 * 60 * 60)
    public void confirmOrder(){
        if (configBeanValue.isDev){
            log.info("系统自动确认收货订单");
            return;
        }
        // 获取15天之前未支付的订单
        List<Order> orders = orderService.listNotConfirmForDays(15);
        if (CollectionUtil.isEmpty(orders)) {
            return;
        }

        // 自动确认收货
        try {
            orders.forEach(order -> {
                TupleRet ret = orderService.confirm(order);
                if (!ret.getSuccess()){
                    log.error(ret.getMessage());
                }
            });

        } catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
