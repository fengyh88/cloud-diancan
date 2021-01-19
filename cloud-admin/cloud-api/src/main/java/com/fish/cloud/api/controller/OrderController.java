package com.fish.cloud.api.controller;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fish.cloud.bean.dto.*;
import com.fish.cloud.bean.model.Dept;
import com.fish.cloud.bean.model.Order;
import com.fish.cloud.bean.model.Table;
import com.fish.cloud.bean.model.User;
import com.fish.cloud.bean.param.OrderBySatusParam;
import com.fish.cloud.bean.param.OrderCloseParam;
import com.fish.cloud.bean.param.OrderCompleteParam;
import com.fish.cloud.common.context.ApiContextHolder;
import com.fish.cloud.common.ret.ApiResult;
import com.fish.cloud.service.IOrderService;
import com.fish.cloud.service.ITableService;
import com.fish.cloud.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author fengyh
 * @since 2020-10-30
 */
@Api(tags = "订单")
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private ITableService tableService;
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "分页", notes = "分页")
    @GetMapping("/pageByStatus")
    @ResponseBody
    public ApiResult<IPage<OrderDto>> pageByStatus(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                   @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize,
                                                   OrderBySatusParam orderBySatusParam) {
        if (!ArrayUtils.contains(new int[]{0, 1, 9, 13}, orderBySatusParam.getStatus())) {
            return ApiResult.failed("订单状态错误");
        }
        IPage<Order> modelPage = orderService.page(new Page<Order>(pageNo, pageSize), new LambdaQueryWrapper<Order>()
                .eq(Order::getShopId, ApiContextHolder.getAuthDto().getShopId())
                .eq(0 != orderBySatusParam.getStatus(), Order::getStatus, orderBySatusParam.getStatus()));
        // dto
        IPage<OrderDto> dtoPage = modelPage.convert(model -> Convert.convert(OrderDto.class, model));
        // 获取列表备用
        var tableList = tableService.all();
        var userList = userService.list();
        // 转换
        dtoPage.getRecords().stream().forEach(orderDto -> {
            Optional<TableDto> tableDtoOptional = tableList.stream().filter(tableDto -> tableDto.getTableId() == orderDto.getTableId()).findFirst();
            if (tableDtoOptional.isPresent()) {
                orderDto.setTableName(tableDtoOptional.get().getTableName());
            }
            Optional<User> userOptional = userList.stream().filter(user -> user.getUserId() == user.getUserId()).findFirst();
            if (userOptional.isPresent()) {
                orderDto.setUserNickName(userOptional.get().getNickName());
                orderDto.setUserImg(userOptional.get().getImg());
            }
        });
        return ApiResult.success(dtoPage);
    }

    @ApiOperation("结算")
    @ApiImplicitParam(name = "orderCompleteParam", value = "结算信息", required = true)
    @PostMapping(value = "/complete")
    public ApiResult complete(@RequestBody OrderCompleteParam orderCompleteParam) {
        var ret = orderService.complete(orderCompleteParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("关闭")
    @ApiImplicitParam(name = "orderCloseParam", value = "关闭信息", required = true)
    @PostMapping(value = "/close")
    public ApiResult close(@RequestBody OrderCloseParam orderCloseParam) {
        var ret = orderService.close(orderCloseParam);
        return ApiResult.fromTupleRet(ret);
    }

    @ApiOperation("根据台桌Id查询待结算列表，然后进行结算")
    @ApiImplicitParam(name = "tableId", value = "台桌Id", required = true)
    @PostMapping(value = "/listByTableId")
    public ApiResult<List<OrderWithItemsDto>> listByTableId(@RequestParam Long tableId) {
        Table table = tableService.getById(tableId);
        if (11 != table.getStatus()) {
            return ApiResult.failed("该台桌未就餐");
        }
        var dtoList = orderService.listByTableId(tableId, 1);
        if (dtoList.size() <= 0) {
            return ApiResult.failed("该台桌没有待结算的单据");
        }
        // 处理总金额，只计算已出餐的总金额
        dtoList.stream().forEach(orderWithItemsDto -> {
            // 过滤出已出餐的明细
            List<OrderItemDto> orderItemDtoList = orderWithItemsDto.getOrderItems().stream().filter(orderItemDto -> 2 == orderItemDto.getStatus()).collect(Collectors.toList());
            BigDecimal totalAmount = orderItemDtoList.stream().map(orderItemDto -> orderItemDto.getTotalAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
            orderWithItemsDto.setTotalAmount(totalAmount);
            // 同时更新数据库
            Order order = orderService.getById(orderWithItemsDto.getOrderId());
            order.setTotalAmount(totalAmount);
            orderService.updateById(order);
        });

        return ApiResult.success(dtoList);
    }
}
