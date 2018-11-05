package cn.controller;

import cn.pojo.Naddress;
import cn.service.NaddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/address")
@Api(value="address",description="收货地址接口")
public class NaddressController {
    @Autowired
    private NaddressService naddressService;
    public NaddressService getNaddressService() {
        return naddressService;
    }

    public void setNaddressService(NaddressService naddressService) {
        this.naddressService = naddressService;
    }


    /*
     * @ApiOperation(value = "接口说明", httpMethod ="接口请求方式", response ="接口返回参数类型", notes ="接口发布说明"
     *
     * @ApiParam(required = "是否必须参数", name ="参数名称", value ="参数具体描述"
     */

    @ResponseBody
    @RequestMapping(value = "/getAllByNaddress")
    @ApiOperation(value="根据ID查询全部收货地址",httpMethod="POST",notes="Szy")
    public String getAllByNaddress(@ApiParam(required = true, name ="用户ID", value ="根据用户ID查询全部收货地址")@RequestParam("uid")int uid){
        String allByNaddress = naddressService.getAllByNaddress(uid);
        return allByNaddress;
    }

    @ResponseBody
    @RequestMapping(value = "/addByAddress")
    @ApiOperation(value="新增收货地址",httpMethod="POST",notes="Szy")
    public String addByAddress(Naddress na){
        String addByAddress = naddressService.addByAddress(na);
        return addByAddress;
    }

    @ResponseBody
    @RequestMapping(value = "/updateByAddress/{na}")
    @ApiOperation(value="编辑更改收货地址",httpMethod="POST",notes="Szy")
    public String updateByAddress(Naddress na){
        String updateByAddress = naddressService.updateByAddress(na);
        return updateByAddress;
    }

    @ResponseBody
        @RequestMapping(value="/updateByIDAddress")
    @ApiOperation(value="根据收货地址ID和用户ID删除（更改收货地址状态nxianshi为0显示1隐藏）",httpMethod="GET",notes="Szy")
    public String updateByIDAddress(@RequestParam("nid")int nid, @RequestParam("uid")int uid){
        String updateByIDAddress = naddressService.updateByIDAddress(nid, uid);
        return updateByIDAddress;
    }

    @ResponseBody
    @RequestMapping(value="/updateByndefaultM")
    @ApiOperation(value="更改默认地址（设置默认）",httpMethod="GET",notes="Szy")
    public String updateByndefaultM(@RequestParam("nid") int nid, @RequestParam("uid")int uid){
        String updateByndefaultM = naddressService.updateByndefaultM(nid, uid);
        return updateByndefaultM;
    }

    @ResponseBody
    @RequestMapping(value = "/updateByndefaultB")
    @ApiOperation(value="更改默认地址（设置不默认）",httpMethod="GET",notes="Szy")
    public String updateByndefaultB(@RequestParam("nid") int nid, @RequestParam("uid")int uid){
        String updateByndefaultB = naddressService.updateByndefaultB(nid, uid);
        return updateByndefaultB;
    }



}
