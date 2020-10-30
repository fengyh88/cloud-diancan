package com.fish.cloud.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.page.PageParam;
import com.fish.cloud.bean.dto.OrderCountStatusDto;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCancelParam;
import com.fish.cloud.common.util.TupleRet;
import com.fish.cloud.repo.OrderMapper;
import com.fish.cloud.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-03-07
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Override
    public TupleRet<List<Order>> listByStatus(OrderBySatusParam orderBySatusParam) {
        try {
            List<Object[]> objects = null;
            switch (orderBySatusParam.getStatus()) {
//                case 0:
//                    //全部
//                    objects = orderRepository.getOrderModelsAll(authDto.getStoreId(), authDto.getUserId());
//                    break;
//                case 1:
//                    //待付款
//                    objects = orderRepository.getOrderModelsByNotPay(authDto.getStoreId(), authDto.getUserId());
//                    break;
//                case 2:
//                    //待发货
//                    objects = orderRepository.getOrderModelsByNotSend(authDto.getStoreId(), authDto.getUserId());
//                    break;
//                case 3:
//                    //待收货
//                    objects = orderRepository.getOrderModelsBySend(authDto.getStoreId(), authDto.getUserId());
//                    break;
//                case 4:
//                    //已完成
//                    objects = orderRepository.getOrderModelsByConfirm(authDto.getStoreId(), authDto.getUserId());
//                    break;
            }
            List<Order> orderResList =new ArrayList<>();
            //List<Order> orderResList = viewToDto(objects);

            //订单详情赋值
            //orderResList.forEach(item -> {
//                List<Object[]> objectsDetail = orderDetailRepository.getOrderDetailModelsByOrderId(item.getId());
//                List<OrderDetailRes> orderDetailResList = detailViewToDto(objectsDetail);
//                item.setOrderDetails(orderDetailResList);
            //});

            return TupleRet.success(orderResList);

        } catch (Exception ex) {
            //logger.error(ex.getStackTrace());
            TupleRet.failed(ex.getStackTrace().toString());
        }

        return TupleRet.failed("查询数据错误");
    }

    @Override
    public TupleRet<Page<Order>> pageByStatus(OrderBySatusParam orderBySatusParam, PageParam<Order> page) {
        List<Order> dtos =baseMapper.selectDtoPage(page, orderBySatusParam.getStatus());
        page.setRecords(dtos);
        return TupleRet.success(page);
    }

    @ApiOperation("订单详情")
    @Override
    public TupleRet<Order> detail(Long id) {
        try {
//            List<Object[]> obj = orderRepository.getOrderModelById(id);
//            if (obj.size()<=0) {
//                return TupleRet.failed("未查询到订单信息");
//            }
//            OrderRes orderRes = viewToDto(obj.get(0));
//
//            //订单详情赋值
//            List<Object[]> objectsDetail = orderDetailRepository.getOrderDetailModelsByOrderId(id);
//            List<OrderDetailRes> orderDetailResList = detailViewToDto(objectsDetail);
//            orderRes.setOrderDetails(orderDetailResList);

            return TupleRet.success();
        } catch (Exception ex) {
            //logger.error(ex.getStackTrace());
            TupleRet.failed(ex.getStackTrace().toString());
        }

        return TupleRet.failed("查询数据错误");
    }

    @Override
    public TupleRet sendNo(Long orderId) {
        var model =baseMapper.selectById(orderId);
        if (null == model){
            return TupleRet.failed("订单不存在");
        }
        //订单已删除或者已发货或者已取消
        if (model.getStatus() == -1) {
            return TupleRet.failed("订单已删除");
        }
        if (model.getStatus() == 1) {
            return TupleRet.failed("订单已取消");
        }
        if (model.getStatus() == 1) {
            return TupleRet.failed("订单已发货");
        }

//        model.setIsApplyCancel(1);
//        model.setApplyCancelContent("不发货取消订单");
//        model.setIsCancel(1);

        //恢复商品库存

        //如果已在线支付
        if ((model.getIsPayed() == 1 && ArrayUtils.contains(new int[]{1, 2}, model.getPayType()))) {
            //退款到用户微信或支付宝账户
            if (model.getPayType() == 1) {
                //退款到微信账户
                var toWxAccount=returnToWxAccount(model);
                if (!toWxAccount.getIsSuccess()){
                    return TupleRet.failed(toWxAccount.getMessage());
                }
            }
        }

        try {
            baseMapper.updateById(model);
        } catch (Exception e) {
           // logger.error(e.getStackTrace());
            return TupleRet.failed(e.getMessage());
        }

        return TupleRet.success();
    }

    @Override
    public TupleRet cancelAudit(Long orderId) {
        Order order = baseMapper.selectById(orderId);

        if (null == order) {
            return  TupleRet.failed("订单不存在") ;
        }

        //订单已删除或者已发货或者已取消
        if (order.getStatus() == 6 || order.getStatus() == 7) {
            return TupleRet.failed("订单已关闭");
        }

        order.setStatus(6);
        order.setCloseType(4);

        try {
            baseMapper.updateById(order);
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return  TupleRet.failed("订单取消审核失败");
        }

        return TupleRet.success("订单取消审核成功");
    }

    @Override
    public TupleRet send(Long orderId) {
        Order order = baseMapper.selectById(orderId);

        if (null == order) {
            return  TupleRet.failed("订单不存在") ;
        }

        //订单已删除或者已发货或者已取消
        if (order.getStatus() == 6 || order.getStatus() == 7) {
            return TupleRet.failed("订单已关闭");
        }

        order.setStatus(6);

        try {
            baseMapper.updateById(order);
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return  TupleRet.failed("订单发货失败");
        }

        return TupleRet.success("订单发货成功");
    }

    @ApiOperation("订单各个状态数量")
    @Override
    public TupleRet<OrderCountStatusDto> getCountStatus() {
        OrderCountStatusDto orderCountStatusRes = new OrderCountStatusDto();
//        orderCountStatusRes.setNotPay(orderRepository.countNotPay(authDto.getStoreId(), authDto.getUserId()));
//        orderCountStatusRes.setNotSend(orderRepository.countNotSend(authDto.getStoreId(), authDto.getUserId()));
//        orderCountStatusRes.setSend(orderRepository.countSend(authDto.getStoreId(), authDto.getUserId()));
//        orderCountStatusRes.setConfirm(orderRepository.countConfirm(authDto.getStoreId(), authDto.getUserId()));

        return TupleRet.success(orderCountStatusRes);
    }

    @Override
    public Boolean updateStatus(Long id, Integer status) {
        Order model = baseMapper.selectById(id);
        if (null == model){
            return true;
        }
        model.setStatus(status);
        baseMapper.updateById(model);
        return true;
    }


    @Override
    public TupleRet cancel(OrderCancelParam orderCancelParam) {
        Order order = baseMapper.selectById(orderCancelParam.getId());

        if (null == order) {
          return  TupleRet.failed("订单不存在") ;
        }

        //订单已删除或者已发货或者已取消
        if (order.getStatus() == 6 || order.getStatus() == 7) {
            return TupleRet.failed("订单已关闭");
        }
        //如果已在线支付 或者是货到面对面支付
        if ((order.getIsPayed() == 1 && order.getIsPayed() == 1)) {
            order.setStatus(11);
            return TupleRet.success("订单取消申请已提交，请等候管理员审核");
        }

        order.setStatus(6);
        order.setCloseType(4);

        //恢复商品库存

        try {
            baseMapper.updateById(order);
        } catch (Exception e) {
            //logger.error(e.getMessage());
            return  TupleRet.failed("订单取消失败");
        }

        return TupleRet.success("订单取消成功");
    }

    private TupleRet returnToWxAccount(Order orderModel){
        return TupleRet.failed();
    }
}