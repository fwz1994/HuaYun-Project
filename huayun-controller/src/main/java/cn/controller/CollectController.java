package cn.controller;


import cn.service.CollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value="/collect")
@Api(value = "collect",description="收藏接口描述")
public class CollectController {

    @Autowired
    private CollectService cc;

    public CollectService getCc() {
        return cc;
    }

    public void setCc(CollectService cc) {
        this.cc = cc;
    }

    @ResponseBody
    @RequestMapping(value = "/getCollect")
    @ApiOperation(value="查询收藏",httpMethod="GET",notes="数据库查询收藏")
    public String a(@RequestParam("pid") int pid){
        String a =cc.addCollect(pid);
        return a;
    }
}
