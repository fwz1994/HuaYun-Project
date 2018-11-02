package cn.service.impl;

import cn.dao.GoodsDao;
import cn.pojo.Goods;
import cn.service.GoodsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao gd;

    @Override
    public String getAll() {
        List<Goods> goodsList = gd.GetAll();
        String jsonString = JSON.toJSONString(goodsList);
        return jsonString;
    }
}
