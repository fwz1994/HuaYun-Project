package cn.dao;

import cn.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单接口
 */
public interface OrderDao {

    /**
     * 新增订单
     * @param order
     * @return
     */
    int addByOrder(Order order);

    /**
     * 删除订单：0显示1隐藏
     * @param oid   订单ID
     * @param ouid  用户ID
     * @return
     */
    int delectByID(@Param("oid") Integer oid, @Param("ouid") Integer ouid);

    /**
     * 分类显示订单：1待付款，2待发货，3待收货，4已完成，5售后
     * @param ouid      用户ID
     * @param ostate    1待付款，2待发货，3待收货，4已完成，5售后
     * @return
     */
    List<Order> sortAllByOrder(@Param("ouid") Integer ouid, @Param("ostate") Integer ostate);

    /**
     * 根据订单状态分类显示订单数目
     * @param ouid     用户ID
     * @param ostate    1待付款，2待发货，3待收货，4已完成，5售后
     * @return
     */
    int sortAllByCount(@Param("ouid") Integer ouid, @Param("ostate") Integer ostate);


}
