package cn.service;

import cn.pojo.Order;

public interface OrderService {

    /**
     * 新增订单
     * @param od
     * @return
     */
    String addByOrder(Order od);

    /**
     * 删除订单：0显示1隐藏
     * @param oid   订单id
     * @param ouid  用户ID
     * @return
     */
    String delectByID(int oid, int ouid);

    /**
     * 分类显示订单：1待付款，2待发货，3待收货，4已完成，5售后
     * @param ouid  用户ID
     * @param ostate    1待付款，2待发货，3待收货，4已完成，5售后
     * @return
     */
    String sortAllByOrder(int ouid, int ostate);

    /**
     * 根据订单状态分类显示订单数目
     * @param ouid      用户ID
     * @param ostate     1待付款，2待发货，3待收货，4已完成，5售后
     * @return
     */
    int sortAllByCount(int ouid, int ostate);


}
