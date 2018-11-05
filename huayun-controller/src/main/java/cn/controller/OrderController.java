package cn.controller;

import cn.pojo.Order;
import cn.service.OrderService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/order")
@Api(value="order",description="订单接口")
public class OrderController {

    @Autowired
    private OrderService ordersv;
    public OrderService getOrdersv() {
        return ordersv;
    }

    public void setOrdersv(OrderService ordersv) {
        this.ordersv = ordersv;
    }

    @ResponseBody
    @RequestMapping(value = "/addByOrder")
    @ApiOperation(value="新增订单",httpMethod="POST",notes="Szy")
    public String addByOrder(Order od){
        String add = ordersv.addByOrder(od);
        return add;
    }

    @ResponseBody
    @RequestMapping(value = "/delectByID")
    @ApiOperation(value="刪除订单",httpMethod="GET",notes="Szy")
    public String delectByID(@RequestParam("oid")int oid, @RequestParam("ouid") int ouid){
        String delect = ordersv.delectByID(oid, ouid);
        return delect;
    }

    @ResponseBody
    @RequestMapping(value = "/sortAllByOrder")
    @ApiOperation(value="分类显示订单：1待付款，2待发货，3待收货，4已完成，5售后",httpMethod="GET",notes="Szy")
    public String sortAllByOrder(@RequestParam("ouid")int ouid, @RequestParam("ostate")int ostate){
        String allByOrder = ordersv.sortAllByOrder(ouid, ostate);
        return allByOrder;
    }

    @ResponseBody
    @RequestMapping(value = "/sortAllByCount")
    @ApiOperation(value="根据订单状态分类显示订单数目",httpMethod="GET",notes="Szy")
    public String sortAllByCount(@RequestParam("ouid")int ouid, @RequestParam("ostate")int ostate){
        int allByCount = ordersv.sortAllByCount(ouid, ostate);
        String count = String.valueOf(allByCount);
        return count;
    }
}
