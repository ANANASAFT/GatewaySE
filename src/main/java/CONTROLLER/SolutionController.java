package CONTROLLER;

import POJO.Gateway;
import POJO.Sensor;
import POJO.Solution;
import SERVICE.GatewayService;
import SERVICE.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolutionController {
    @Autowired
    private GatewayService gatewayService;
    @Autowired
    private SensorService sensorService;

    @RequestMapping(value = "/solution", method = RequestMethod.POST)
    @ResponseBody
    public List<Solution> getMatchedGatewayAndsensor(@RequestBody Map M){
        List<Solution> list=new ArrayList<>();
        if (M != null) {
            Map sensorParameters = (Map) M.get("sensorParameters");
            Map sensorWorkingEnv = (Map) M.get("sensorWorkingEnv");
            Map gatewayWorkingEnv=(Map) M.get("gatewayWorkingEnv");
            List<Sensor> sensorList=sensorService.getNeededSensor(sensorWorkingEnv);
            List<Gateway> gatewayList=gatewayService.getNeededGateway(gatewayWorkingEnv);
            for(int i=0;i<sensorList.size();i++){
                Sensor sensor=sensorList.get(i);
                String sensorModel=sensor.getModel();
                String sensorBrand=sensor.getBrand();
                int sensorId=sensor.getId();
                for(int j=0;j<gatewayList.size();j++){
                    Gateway gateway=gatewayList.get(j);
                    String gatewayModel=gateway.getModel();
                    String gatewayBrand=gateway.getBrand();
                    int gatewaId=gateway.getId();
                    Solution solution=new Solution(gatewaId,gatewayModel,gatewayBrand,sensorId,sensorModel,sensorBrand);
                    list.add(solution);
                }
            }
        }
        return list;

    }
}
