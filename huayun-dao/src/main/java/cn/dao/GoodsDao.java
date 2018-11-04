package cn.dao;

import cn.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品接口
 */
public interface GoodsDao {
    /**
     * 首页商品展示
     * @return
     */
    List<Goods> getAllByGoods();

    /**
     *搜索（模糊查询）
     * @param gname
     * @return
     */
    List<Goods> getFuzzyByGoods(@Param("gname") String gname);

    /**
     * 首页分类（根据类型分类）
     * @param gtype
     * @return
     */
    List<Goods> getTypeByGoods(@Param("gtype") Integer gtype);

    /**
     * 商品详细信息(通过ID查询)
     * @param gid
     * @return
     */
    List<Goods> getIDByGoodsAndDetail(@Param("gid") Integer gid);

    /**
     * 分页
     * @param goods
     * @return
     */
    List<Goods> getAllType(Goods goods);

}
