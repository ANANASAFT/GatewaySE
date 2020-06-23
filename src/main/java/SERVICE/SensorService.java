package SERVICE;

import POJO.Sensor;

import java.util.List;
import java.util.Map;

public interface SensorService {
      //获取指定参数的传感器信息
      List<Sensor> getNeededSensor(Map M);

      List<Sensor> getNeededSensor(Map M, int page, int size);

      //获取所有分页信息，分页
      List<Sensor> queryAllSensorPaged(int page, int size);

      //根据品牌信息返回相应的网关信息
      List<Sensor> getNeededSensorByBrand(String brand);

      //根据品牌信息返回相应的网关信息
      List<Sensor> getNeededSensorByBrandPaged(String brand, int page, int size);


      //根据id返回指定的网关
      Sensor getNeededSensorByid(int id);

      //插入一条新的网关数据
      boolean insert(Sensor sensor);

      //根据id删除指定的id信息
      boolean deleteSensorInfo(int id);

      //更新网关信息
      boolean updateSensorInfo(Sensor sensor);
 }
