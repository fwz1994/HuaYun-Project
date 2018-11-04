package cn.dao;

import cn.pojo.Naddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 地址接口
 */
public interface NaddressDao {

    /**
     * 查看全部收货地址
     * @return
     */
    List<Naddress> getAllByNaddress(@Param("nuid") Integer nuid);

    /**
     * 新增地址
     * @param na
     * @return
     */
    int addByAddress(Naddress na);

    /**
     * 编辑更改地址
     * @param na
     * @return
     */
    int updateByAddress(Naddress na);

    /**
     * 根据收货地址ID和用户ID删除（更改收货地址状态nxianshi为0显示1隐藏）
     * @param nid
     * @param nuid
     * @return
     */
    int updateByIDAddress(@Param("nid") Integer nid, @Param("nuid") Integer nuid);

    /**
     * 更改默认地址（设置默认）
     * @param nid
     * @param nuid
     * @return
     */
    int updateByndefaultM(@Param("nid") Integer nid, @Param("nuid") Integer nuid);

    /**
     * 更改默认地址（设置不默认）
     * @param nid
     * @param nuid
     * @return
     */
    int updateByndefaultB(@Param("nid") Integer nid, @Param("nuid") Integer nuid);

    /**
     * 查询用户ID下的总地址数
     * @param nuid
     * @return
     */
    int countByNaddress(@Param("nuid") Integer nuid);

}
