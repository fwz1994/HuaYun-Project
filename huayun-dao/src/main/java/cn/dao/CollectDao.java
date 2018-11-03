package cn.dao;

import cn.pojo.Collect;
import cn.pojo.Goods;
import cn.pojo.UserLink;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收藏接口
 */
public interface CollectDao {
    /**
     * 查询所有收藏
     * @param cyhid 用户id
     * @return
     */
    List<Collect> getAllByColler(@Param("cyhid")Integer cyhid);

    /**
     * 按收藏查询商品id
     * @param gid
     * @return
     */
 /*   Goods getCollerByGood(@Param("gid") Integer gid);*/

}
