package cn.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 地址接口
 */
public interface Naddress {

    /**
     * 新增地址
     * @param na
     * @return
     */
    int AddByAddress(Naddress na);

    /**
     * 编辑更改地址
     * @param na
     * @return
     */
    int UpdateByAddress(Naddress na);

    /**
     * 根据收货地址ID和用户ID删除（更改收货地址状态nxianshi为0显示1隐藏）
     * @param nid
     * @param nuid
     * @return
     */
    int UpdateByIDAddress(@Param("nid") Integer nid,@Param("nuid") Integer nuid);

}
