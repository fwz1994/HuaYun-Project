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

    /**
     * 首页（分类）
     * @param gtype
     * @return
     */
    String getTypeByGoods(Integer gtype);

    /**
     * 商品详情
     * @param gid
     * @return
     */
    String getIDByGoodsAndDetail(Integer gid);

    /**
     * 分页
     * @param index 起始页数
     * @param pagesize 每页显示条数
     * @return
     */
    String getPageByIndex(Integer index,Integer pagesize);
}


