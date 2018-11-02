package cn.dao;

import cn.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品接口
 */
public interface GoodsDao {

    List<Goods> getAllByGoods();

    /**
     *搜索（模糊查询）
     * @param gname
     * @return
     */
    List<Goods> getFuzzyByGoods(@Param("gname") String gname);
    List<Goods> getTypeByGoods(@Param("gtype") Integer gtype);
}
