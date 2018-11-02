package cn.service.impl;

import cn.dao.GoodsDao;
import cn.pojo.Goods;
import cn.service.GoodsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao gd;

    public GoodsDao getGd() {
        return gd;
    }

    public void setGd(GoodsDao gd) {
        this.gd = gd;
    }

    /**
     * 首页商品展示
     * @return
     */
    @Transactional
    public String getAllByGoods() {
        List<Goods> allByGoods = gd.getAllByGoods();
        String jsonString = JSON.toJSONString(allByGoods);
        return jsonString;
    }

    /**
     * （搜索）模糊查询
     * @param gname
     * @return
     */
    @Transactional
    public String getFuzzyByGoods(String gname) {
        if(gname != null ){
            List<Goods> fuzzyByGoods = gd.getFuzzyByGoods(gname);
            String jsonStringFuzzy = JSON.toJSONString(fuzzyByGoods);
            return jsonStringFuzzy;
        }else{
            return null;
        }

    }

    /**
     *
     * @param gtype
     * @return
     */
    @Transactional
    public String  getTypeByGoods(Integer gtype) {
        if (gtype != null){
            List<Goods> typeByGoods = gd.getTypeByGoods(gtype);
            String jsonStringType = JSON.toJSONString(typeByGoods);
            return jsonStringType;
        }else{
            return null;
        }

    }


}
