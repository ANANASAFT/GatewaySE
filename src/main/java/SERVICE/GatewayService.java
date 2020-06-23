package SERVICE;

import POJO.Gateway;

import java.util.List;
import java.util.Map;

public interface GatewayService {
      //获取指定参数的网关信息
      List<Gateway> getNeededGateway(int industrialGrade, double temperatureLow, double
              temperatureHigh, double currentLow, double currentHigh);

      List<Gateway> getNeededGateway(Map M);

      List<Gateway> getNeededGateway(Map M,int page ,int size);

      //获取所有分页信息，分页
      List<Gateway> queryAllGatewayPaged(int page,int size);

      //根据品牌信息返回相应的网关信息
      List<Gateway> getNeededGatewayByBrand(String brand);

      //根据品牌信息返回相应的网关信息
      List<Gateway> getNeededGatewayByBrandPaged(String brand,int page,int size);


      //根据id返回指定的网关
      Gateway getNeededGatewayByid(int id);

      //插入一条新的网关数据
      boolean insert(Gateway gateway);

      //根据id删除指定的id信息
      boolean deleteGatewayInfo(int id);

      //更新网关信息
      boolean updateGatewayInfo(Gateway gateway);
 }
