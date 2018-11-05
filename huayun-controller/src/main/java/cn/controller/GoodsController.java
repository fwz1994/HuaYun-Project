package cn.controller;

import cn.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/goods")
@Api(value = "goods",description="商品展示")
public class GoodsController {
    /*
     * @ApiOperation(value = "接口说明", httpMethod ="接口请求方式", response ="接口返回参数类型", notes ="接口发布说明"
     *
     * @ApiParam(required = "是否必须参数", name ="参数名称", value ="参数具体描述"
     */
    @Resource
    private GoodsService gs;
    public GoodsService getGs() {
        return gs;
    }
    public void setGs(GoodsService gs) {
        this.gs = gs;
    }
    @ResponseBody
    @RequestMapping(value = "/getall")
    @ApiOperation(value="查询全部信息",httpMethod="POST",notes="数据库查询商品表全部信息")
    public String getAllController(){
        String allByGoods = gs.getAllByGoods();
        return allByGoods;
    }

    @ResponseBody
    @RequestMapping(value = "/getfuzzy")
    @ApiOperation(value="搜索（模糊查询）",httpMethod="POST",notes="数据库查询商品表（商品名称）")
    public String getfuzzyController(@RequestParam("gname") String gname){
        String fuzzyByGoods = gs.getFuzzyByGoods(gname);
        return fuzzyByGoods;
    }

    @ResponseBody
    @RequestMapping(value = "/gettype")
    @ApiOperation(value="首页（分类查询）",httpMethod="POST",notes="数据库查询商品表（商品类型）")
    public String getTypeController(@RequestParam("gtype") Integer gtype){
        String typeByGoods = gs.getTypeByGoods(gtype);
        return typeByGoods;
    }


    @ResponseBody
    @RequestMapping("/all")
    @ApiOperation(value="首页（分页）",httpMethod="POST",notes="数据库查询商品表")
    public String fenye(){
        return gs.getPageByIndex(1,2);
    }


    @ResponseBody
    @RequestMapping(value = "/getgid")
    @ApiOperation(value="商品详情（连表查询）",httpMethod="GET",notes="数据库查询商品表和详情表（商品表ID）")
    public String getIDController(@RequestParam("gid") Integer gid){
        String idByGoodsAndDetails = gs.getIDByGoodsAndDetail(gid);
        return idByGoodsAndDetails;
    }
}
