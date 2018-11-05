package cn.service.impl;

import cn.dao.OrderDao;
import cn.pojo.Order;
import cn.service.OrderService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.VerifyUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service("dingdan")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao ordo;

    @Autowired
    private VerifyUtil util;

    /**
     * 新增订单
     * @param od
     * @return
     */
    @Override
    public String addByOrder(Order od) {
        String addOrder = null;
        String obianhao = od.getObianhao();
        String otitle = od.getOtitle();
        String odate = od.getOdate();
        Integer ostate = od.getOstate();
        String opayment = od.getOpayment();
        String ocoupon = od.getOcoupon();
        String ofreight = od.getOfreight();
        String ocontact = od.getOcontact();
        String omessage = od.getOmessage();
        String otime = od.getOtime();
        String oremark = od.getOremark();
        Integer obuy = od.getObuy();
        if(obianhao != null){
            if(obianhao.length() != 18){
                addOrder = "订单编号格式不正确...";
                return addOrder;
            }
        }
        if(otitle!= null){
            if(otitle.length() >= 20){
                addOrder = "标题过长...";
                return addOrder;
            }
        }
        if(odate != null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            boolean date = true;
            try {
                df.setLenient(false);
                df.parse(odate);
            } catch (ParseException e) {
                date = false;
            }
            if(date == false){
                addOrder = "订单时间格式不正确...";
                return addOrder;
            }
        }
        if(ostate != null && ostate != 0 && ostate >0 && ostate <= 5){
            if(obuy == 0){
                od.setOstate(2);
            }else {
                od.setOstate(1);
            }
        }
        if(opayment != null){
            od.setOpayment(opayment);
        }else {
            addOrder = "支付方式不能为空...";
            return addOrder;
        }
        if(ocoupon != null){
            if(ocoupon.length() == 0){
                addOrder = "您目前没有领取优惠卷...";
                return addOrder;
            }
        }
        if(ofreight != null){
            if(!ofreight.equals("0")){
                od.setOfreight(ofreight);
            }
        }
        if(ocontact != null){
            if(ocontact.length() != 11){
                addOrder = "订购人联系方式应为11位手机号...";
                return addOrder;
            }else {
                od.setOcontact(ocontact);
            }
        }else {
            addOrder = "订购人联系方式不可以为空...";
            return addOrder;
        }
        if(omessage != null){
            if(omessage.length() <= 20){
                od.setOmessage(omessage);
            }else {
                addOrder = "留言不可以超过20个字符长度...";
                return addOrder;
            }
        }
        if(otime != null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            boolean flags = true;
            try {
                df.setLenient(false);
                df.parse(otime);
            } catch (ParseException e) {
                flags =false;
            }
            if(flags == false){
                addOrder = "配送日期格式不正确...";
                return addOrder;
            }
        }else {
            addOrder = "配送日期不可以为空...";
            return addOrder;
        }
        if(oremark != null){
            if(oremark.length() <= 20){
                od.setOremark(oremark);
            }else {
                addOrder = "备注的字符长度不能超过20个字符...";
                return addOrder;
            }
        }
        if(obuy != null){
            if(obuy.equals(1)){
                od.setOstate(1);
                addOrder = "订单支付失败";
                return addOrder;
            }else if(obuy.equals(0)){
                od.setOstate(2);
                addOrder = "订单支付成功";
                return addOrder;
            }
        }

        int addByOrder = ordo.addByOrder(od);
        if(addByOrder > 0){
            addOrder = "订单支付成功";
        }else {
            addOrder = "订单支付失败";
        }
        return addOrder;
    }

    /**
     * 删除订单
     * @param oid   订单id
     * @param ouid  用户ID
     * @return
     */
    @Override
    public String delectByID(int oid, int ouid) {
        String delect = null;
        if(oid != 0 && ouid != 0){
            int delectbyID = ordo.delectByID(oid, ouid);
            if(delectbyID != 0){
                delect = "删除成功";
            }else {
                delect = "删除失败";
            }
        }

        return delect;
    }

    /**
     *分类显示订单：1待付款，2待发货，3待收货，4已完成，5售后
     * @param ouid  用户ID
     * @param ostate    1待付款，2待发货，3待收货，4已完成，5售后
     * @return
     */
    @Override
    public String sortAllByOrder(int ouid, int ostate) {
        String sort = null;
        if(ouid != 0 && ostate != 0){
            List<Order> orderList = ordo.sortAllByOrder(ouid, ostate);
            if(orderList != null){
                String jsonString = JSON.toJSONString(orderList);
                return jsonString;
            }else {
                sort = "您还没有相关的订单...";
            }
        }else {
            if(ouid != 0){
                sort = "用户不存在...";
            }else if(ostate != 0){
                sort = "你的操作丢失...喵喵喵";
            }
        }
        return sort;
    }

    /**
     * 根据订单状态分类显示订单数目
     * @param ouid      用户ID
     * @param ostate     1待付款，2待发货，3待收货，4已完成，5售后
     * @return  0不显示
     */
    @Override
    public int sortAllByCount(int ouid, int ostate) {
        if(ouid != 0 & ostate != 0 ){
            int allByCount = ordo.sortAllByCount(ouid, ostate);
            if(allByCount != 0){
                return allByCount;
            }
        }
        return 0;
    }
}
