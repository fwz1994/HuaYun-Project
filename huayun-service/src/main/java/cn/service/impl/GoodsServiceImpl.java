package cn.service.impl;

import cn.dao.GoodsDao;
import cn.pojo.Goods;
import cn.service.GoodsService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        if (gname != null){
            List<Goods> fuzzyByGoods = gd.getFuzzyByGoods(gname);
            String jsonStringFuzzy = JSON.toJSONString(fuzzyByGoods);
            return jsonStringFuzzy;
        }else{
            return null;
        }

    }

    /**
     *首页（分类）
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
            return "请重新点击";
        }

    }

    /**
     * 商品详情
     * @param gid
     * @return
     */
    @Transactional
    public String getIDByGoodsAndDetail(Integer gid) {
        if (gid != null){
            List<Goods> idByGoodsAndDetail = gd.getIDByGoodsAndDetail(gid);
            String jsonStringId = JSON.toJSONString(idByGoodsAndDetail);
            return jsonStringId;
        }else{
            return "你没进行任何操作";
        }
    }

    /**
     * 分页
     * @param index 起始页数
     * @param pagesize 每页显示条数
     * @return
     */
    @Transactional
    @Override
    public String getPageByIndex(Integer index, Integer pagesize) {
        PageHelper.startPage(index,pagesize);
        List<Goods> typeForms = gd.getAllType(null);
        PageInfo<Goods> goods = new PageInfo<Goods>(typeForms);
        return JSON.toJSONString(goods);
    }
}
