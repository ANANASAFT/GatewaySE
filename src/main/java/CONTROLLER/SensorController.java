package CONTROLLER;


import POJO.Sensor;
import SERVICE.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController  //必须使用RestController，不能使用Controller？why？
@RequestMapping("/api")
public class SensorController {
    @Autowired
    private SensorService sensorService;


    //根据id查询相应的传感器
    @RequestMapping("/sensor/queryid/{id}")
    public Sensor getSensorById(@PathVariable("id") int id){
        return sensorService.getNeededSensorByid(id);
    }

    //根据id删除数据库传感器信息
    @RequestMapping("/sensor/delete/{id}")
    public boolean deleteSensorInfo(@PathVariable("id") int id){
        return sensorService.deleteSensorInfo(id);
    }

    //根据品牌查询相应的传感器
    @RequestMapping("/sensor/querybrand/{brand}/{page}")
    public List<Sensor> getNeededSensorByBrand(@PathVariable("brand")String brand,@PathVariable("page")int page){
        return sensorService.getNeededSensorByBrandPaged(brand,page,10);
    }

    //插入一条传感器信息
    @RequestMapping(value="/sensor/insert",method = RequestMethod.POST)
    @ResponseBody
    public boolean insert(@RequestBody Sensor sensor){
        return sensorService.insert(sensor);
    }

    //用于查询所需的传感器信息,分页
    @RequestMapping(value="/sensor/neededPage",method= RequestMethod.POST)
    @ResponseBody
    public List<Sensor> getNeededSensor(@RequestBody Map M){
        Integer page =(Integer) M.get("page");
        return sensorService.getNeededSensor(M,page,10);
    }

    //用于查询所有传感器信息并分页返回
    @RequestMapping(value ="/sensor/all/{page}")
    public List<Sensor> queryAllSensorPaged(@PathVariable("page") int page){
        return sensorService.queryAllSensorPaged(page,10);
    }

    //修改传感器相关信息
    @RequestMapping(value="/sensor/update",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateSensorInfo(@RequestBody Sensor sensor){
        return sensorService.updateSensorInfo(sensor);
    }


}
