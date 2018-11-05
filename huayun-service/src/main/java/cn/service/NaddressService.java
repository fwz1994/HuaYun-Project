package cn.service;

import cn.pojo.Naddress;

public interface NaddressService {
    /**
     * 查询全部收货地址
     * @param uid   用户ID
     * @return
     */
    String getAllByNaddress(int uid);

    /**
     * 新增收货地址
     * @param na
     * @return
     */
    String addByAddress(Naddress na);

    /**
     * 更改编辑地址
     * @param na
     * @return
     */
    String updateByAddress(Naddress na);

    /**
     *根据收货地址ID和用户ID删除（更改收货地址状态nxianshi为0显示1隐藏）
     * @param nid   地址ID
     * @param uid   用户ID
     * @return
     */
    String updateByIDAddress(int nid, int uid);

    /**
     * 更改默认地址（设置默认）
     * @param nid   地址ID
     * @param uid   用户ID
     * @return
     */
    String updateByndefaultM(int nid, int uid);

    /**
     * 更改默认地址（设置不默认）
     * @param nid   地址ID
     * @param uid   用户ID
     * @return
     */
    String updateByndefaultB(int nid, int uid);
}
