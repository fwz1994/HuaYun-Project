package cn.service;

import cn.pojo.Collect;

import java.util.List;

public interface CollectService {
    /**
     * 查询收藏信息
     * @return
     */
    String addCollect(Integer pid);

    /**
     * 删除收藏商品
     * @param cyhid 用户id
     * @param cspid 商品id
     * @return
     */
    String updCollect(Integer cyhid , Integer cspid);

    /**
     * 收藏商品
     * @param cyhid 用户id
     * @param cspid 商品id
     * @return
     */
    String insCollect(Integer cyhid, Integer cspid);
}
