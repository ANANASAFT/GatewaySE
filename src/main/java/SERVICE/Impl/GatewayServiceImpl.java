package SERVICE.Impl;

import DAO.GatewayDao;
import POJO.Gateway;
import SERVICE.GatewayService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GatewayServiceImpl implements GatewayService {
    @Override
    public List<Gateway> getNeededGateway(int industrialGrade, double temperatureLow, double temperatureHigh, double currentLow, double currentHigh) {
        return GatewayDao.getNeededGeteway(industrialGrade, temperatureLow, temperatureHigh, currentLow, currentHigh);
    }

    @Override
    public List<Gateway> getNeededGateway(Map M) {
        return GatewayDao.getNeededGeteway(M);
    }

    @Override
    public List<Gateway> getNeededGateway(Map M, int page, int size) {
        return GatewayDao.getNeededGeteway(M, page, size);
    }

    @Override
    public List<Gateway> queryAllGatewayPaged(int page, int size) {
        return GatewayDao.queryAllGatewayPaged(page, size);
    }

    @Override
    public List<Gateway> getNeededGatewayByBrand(String brand) {
        return GatewayDao.getNeededGatewayByBrand(brand);
    }

    @Override
    public List<Gateway> getNeededGatewayByBrandPaged(String brand, int page, int size) {
        return GatewayDao.getNeededGatewayByBrandPaged(brand,page,size);
    }

    @Override
    public Gateway getNeededGatewayByid(int id) {
        return GatewayDao.getNeededGatewayByid(id);
    }

    @Override
    public boolean insert(Gateway gateway) {
         return GatewayDao.insert(gateway);
    }

    @Override
    public boolean deleteGatewayInfo(int id) {
        return GatewayDao.deleteGatewayInfo(id);
    }

    @Override
    public boolean updateGatewayInfo(Gateway gateway) {
        return GatewayDao.updateGatewayInfo(gateway);
    }
}
