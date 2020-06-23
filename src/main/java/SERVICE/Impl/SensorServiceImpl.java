package SERVICE.Impl;

import DAO.SensorDao;
import POJO.Sensor;
import SERVICE.SensorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SensorServiceImpl implements SensorService {

    @Override
    public List<Sensor> getNeededSensor(Map M) {
        return SensorDao.getNeededSensor(M);
    }

    @Override
    public List<Sensor> getNeededSensor(Map M, int page, int size) {
        return SensorDao.getNeededSensor(M, page, size);
    }

    @Override
    public List<Sensor> queryAllSensorPaged(int page, int size) {
        return SensorDao.queryAllSensorPaged(page, size);
    }

    @Override
    public List<Sensor> getNeededSensorByBrand(String brand) {
        return SensorDao.getNeededSensorByBrand(brand);
    }

    @Override
    public List<Sensor> getNeededSensorByBrandPaged(String brand, int page, int size) {
        return SensorDao.getNeededSensorByBrandPaged(brand,page,size);
    }

    @Override
    public Sensor getNeededSensorByid(int id) {
        return SensorDao.getNeededSensorByid(id);
    }

    @Override
    public boolean insert(Sensor sensor) {
        return SensorDao.insert(sensor);
    }

    @Override
    public boolean deleteSensorInfo(int id) {
        return SensorDao.deleteSensorInfo(id);
    }

    @Override
    public boolean updateSensorInfo(Sensor sensor) {
        return SensorDao.updateSensorInfo(sensor);
    }
}
