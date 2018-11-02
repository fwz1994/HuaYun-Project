package cn.service;

import cn.pojo.Goods;

import java.util.List;

public interface GoodsService {

    /**
     * 首页（商品展示）
     *
     * @return
     */
    String getAllByGoods();

    /**
     * 搜索（模糊查询）
     *
     * @param gname
     * @return
     */
    String getFuzzyByGoods(String gname);

    String getTypeByGoods(Integer gtype);

}
