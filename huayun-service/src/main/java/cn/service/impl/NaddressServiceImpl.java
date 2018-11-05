package cn.service.impl;

import cn.dao.NaddressDao;
import cn.pojo.Naddress;
import cn.service.NaddressService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.VerifyUtil;

import java.util.List;

@Service
public class NaddressServiceImpl implements NaddressService {
    @Autowired
    private NaddressDao nado;

    public NaddressDao getNado() {
        return nado;
    }
    public void setNado(NaddressDao nado) {
        this.nado = nado;
    }
    @Autowired
    private VerifyUtil util;

    public VerifyUtil getUtil() {
        return util;
    }
    public void setUtil(VerifyUtil util) {
        this.util = util;
    }

    /**
     * 根据ID查询全部收货地址
     * @param uid   用户ID
     * @return
     */

    public String getAllByNaddress(int uid) {
        List<Naddress> allByNaddress = nado.getAllByNaddress(uid);
        if(uid != 0){
            if(allByNaddress != null){
                String jsonString = JSON.toJSONString(allByNaddress);
                return jsonString;
            }else{
                return "您的收货地址空空如也...";
            }
        }else{
            return "用户不存在...";
        }
    }


    /**
     *  新增收货地址
     * @param na
     * @return
     */
    @Override
    public String addByAddress(Naddress na) {
        String address = null;
        String nname = na.getNname();
        String nphone = na.getNphone();
        String nsheng = na.getNsheng();
        String nshi = na.getNshi();
        String nqu = na.getNqu();
        String ndetail = na.getNdetail();
        StringBuffer bf = new StringBuffer(nsheng);
        StringBuffer shengshi = bf.append(nshi);
        StringBuffer qu = shengshi.append(nqu);
        StringBuffer detail = qu.append(ndetail);
        String npostcode = na.getNpostcode();
//        if(util.name(nname) != null && util.Phone(nphone) != null){
        if(nado.countByNaddress(na.getNuid()) >= 5){
            return "您所添加的地址已上限，请删除后再添加!";
        }
        if(nado.countByNaddress(na.getNuid()) == 0){
            na.setNdefault(0);
        }else{
            na.setNdefault(1);
        }
        int byAddress = nado.addByAddress(na);
        if(byAddress != 0){
            address = "添加成功";
        }else {
            address = "添加失败";
        }
//        }else {
//            return "你的格式不正确，请重新输入...";
//        }

        return address;
    }

    /**
     * 编辑更改收货地址
     * @param na
     * @return
     */
    @Override
    public String updateByAddress(Naddress na) {
        String updateByuid = null;
        String nname = na.getNname();
        String nphone = na.getNphone();
        String nsheng = na.getNsheng();
        String nshi = na.getNshi();
        String nqu = na.getNqu();
        String ndetail = na.getNdetail();
        String npostcode = na.getNpostcode();
        if(nname != null){
            if(util.name(nname) != null){
                return nname;
            }
        }
        if(nphone != null){
            if(util.Phone(nphone) != null){
                return nphone;
            }
        }
        if(nsheng != null){
            if(nsheng.contains("省") && nsheng.length() <= 4){
                return nsheng;
            }
        }
        if(nshi != null){
            if(nshi.contains("市") && nshi.length() <= 5){
                return nshi;
            }
        }
        if(nqu != null){
            if(nqu.contains("区") || nqu.contains("县") && nqu.length() <= 8){

                return nqu;
            }
        }
        if(ndetail != null){
            if(ndetail.length() <= 20){
                return ndetail;
            }
        }
        if(npostcode != null){
            if(util.postcode(npostcode) != null){
                return npostcode;
            }
        }
        int updateByAddress = nado.updateByAddress(na);
        if(updateByAddress != 0){
            updateByuid = "更改成功";
        }else {
            updateByuid = "更改失败";
        }

        return updateByuid;
    }

    /**
     * 根据收货地址ID和用户ID删除（更改收货地址状态nxianshi为0显示1隐藏）
     * @param nid   地址ID
     * @param uid   用户ID
     * @return
     */
    @Override
    public String updateByIDAddress(int nid, int uid) {
        String delect = null;
        if(nid != 0 && uid != 0){
            int delectByID = nado.updateByIDAddress(nid, uid);
            if(delectByID != 0){
                delect = "删除成功";
            }else {
                delect = "删除失败";
            }
        }
        return delect;
    }

    /**
     * 更改默认地址（设置默认）
     * @param nid   地址ID
     * @param uid   用户ID
     * @return
     */
    @Override
    public String updateByndefaultM(int nid, int uid) {
        String Moren = null;
        if(nid != 0 && uid != 0){
            int updateM = nado.updateByndefaultM(nid, uid);
            if(updateM != 0){
                Moren = "更改成功";
            }else {
                Moren = "更改失败";
            }
        }
        return Moren;
    }

    /**
     * 更改默认地址（设置不默认）
     * @param nid   地址ID
     * @param uid   用户ID
     * @return
     */
    @Override
    public String updateByndefaultB(int nid, int uid) {
        String NotMoren = null;
        if(nid != 0 && uid != 0){
            int updateB = nado.updateByndefaultB(nid, uid);
            if(updateB != 0){
                NotMoren = "更改成功";
            }else {
                NotMoren = "更改失败";
            }
        }
        return NotMoren;
    }
}
