package cn.service.impl;

import cn.dao.CollectDao;
import cn.pojo.Collect;
import cn.pojo.Goods;
import cn.service.CollectService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao cl;

    /**
     * 查询收藏(cl.gd 商品信息)
     * @param pid 用户id
     * @return
     */
    @Transactional
    @Override
    public String addCollect(Integer pid) {
        String collect = null;
        List<Collect> co = cl.getAllByColler(pid);

        if(pid != null && pid != 0){
            if(co != null){
                String jsonString = JSON.toJSONString(co);
                return jsonString;
            }else {
                collect = "没有收藏商品...";
            }
        }else {
            collect = "未登录,请授权登录...";
        }

        return collect;
    }
    @Transactional
    @Override
    public String updCollect(Integer cyhid, Integer cspid) {
        String updCollect = null;
        int  csc = cl.updaColler(cyhid,cspid);
        if(csc == 0){
            updCollect =  "删除收藏失败";
        }else{
            updCollect = "删除收藏成功";
        }
        return updCollect;
    }
    @Transactional
    @Override
    public String insCollect(Integer cyhid, Integer cspid) {
        String indCollect = null;
        int ind = cl.insColler(cyhid,cspid);
        if(cspid != null){
            if(ind ==0){
                indCollect = "收藏失败,请查看是否点击错误";
            }else{
                indCollect = "收藏成功,请在收藏商品查看";
            }

        }else{
            indCollect = "无此商品,请点击查看商品是否存在";
        }
        return indCollect;
    }

}
