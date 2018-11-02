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
    int AddOrder(Order order);

    /**
     * 根据ID删除订单：0显示，1隐藏
     * @return
     */
    int UpdateByID(@Param("oid") Integer oid);

    /**
     * 显示全部订单：0显示1隐藏
     * @return
     */
    List<Order> GetAllByOrder();

    /**
     * 订单总数：0显示1隐藏
     * @return
     */
    int AllCount();


}
