package POJO;

public class Solution {
    int  gatewayId;
    String gatewayModel;
    String gatewayBrand;

    int SensorId;
    String sensorModel;
    String sensorBrand;

    public Solution() {
    }

    public Solution(int gatewayId, String gatewayModel, String gatewayBrand, int sensorId, String sensorModel, String sensorBrand) {
        this.gatewayId = gatewayId;
        this.gatewayModel = gatewayModel;
        this.gatewayBrand = gatewayBrand;
        SensorId = sensorId;
        this.sensorModel = sensorModel;
        this.sensorBrand = sensorBrand;
    }

    public int getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(int gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getGatewayModel() {
        return gatewayModel;
    }

    public void setGatewayModel(String gatewayModel) {
        this.gatewayModel = gatewayModel;
    }

    public String getGatewayBrand() {
        return gatewayBrand;
    }

    public void setGatewayBrand(String gatewayBrand) {
        this.gatewayBrand = gatewayBrand;
    }

    public int getSensorId() {
        return SensorId;
    }

    public void setSensorId(int sensorId) {
        SensorId = sensorId;
    }

    public String getSensorModel() {
        return sensorModel;
    }

    public void setSensorModel(String sensorModel) {
        this.sensorModel = sensorModel;
    }

    public String getSensorBrand() {
        return sensorBrand;
    }

    public void setSensorBrand(String sensorBrand) {
        this.sensorBrand = sensorBrand;
    }
}
