package CONTROLLER;

import POJO.Gateway;
import SERVICE.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController  //必须使用RestController，不能使用Controller？why？
@RequestMapping("/api")
public class GatewayController {
    @Autowired
    private GatewayService gatewayService;


    //根据id查询相应的网关
    @RequestMapping("/gateway/queryid/{id}")
    public Gateway getGatewayById(@PathVariable("id") int id){
        return gatewayService.getNeededGatewayByid(id);
    }

    //根据id删除数据库网关信息
    @RequestMapping("/gateway/delete/{id}")
    public boolean deleteGatewayInfo(@PathVariable("id") int id){
        return gatewayService.deleteGatewayInfo(id);
    }

    //根据品牌查询相应的网关
    @RequestMapping("/gateway/querybrand/{brand}/{page}")
    public List<Gateway> getNeededGatewayByBrand(@PathVariable("brand")String brand,@PathVariable("page")int page){
        return gatewayService.getNeededGatewayByBrandPaged(brand,page,10);
    }

    //查询所有的网关信息并分页返回
    @RequestMapping(value="/gateway/insert",method= RequestMethod.POST)
    @ResponseBody
    public boolean insert(@RequestBody Gateway gateway){
        return gatewayService.insert(gateway);
    }

    @RequestMapping(value="/gateway/all/{page}")
    public List<Gateway> queryAllPaged(@PathVariable("page") int page){
        return gatewayService.queryAllGatewayPaged(page,10);
    }

    //用于查询所需的网关信息,分页
    @RequestMapping(value="/gateway/neededPage",method= RequestMethod.POST)
    @ResponseBody
    public List<Gateway> getNeededGateway(@RequestBody Map M){
        Integer page =(Integer) M.get("page");
        return gatewayService.getNeededGateway(M,page,10);
    }

    //修改网关相关信息
    @RequestMapping(value="/gateway/update",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateGatewayInfo(@RequestBody Gateway gateway){
        return gatewayService.updateGatewayInfo(gateway);
    }


}
