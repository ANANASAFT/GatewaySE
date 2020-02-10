package POJO;

/**
 * @author: Toon
 * @create: 2020-02-10 14:09
 **/
public class GatewayParameters {
    int industrial_grade;
    float temperatureLow;
    float temperatureHigh;
    float current;

    public int getIndustrial_grade() {
        return industrial_grade;
    }

    public void setIndustrial_grade(int industrial_grade) {
        this.industrial_grade = industrial_grade;
    }

    public float getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(float temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    public float getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(float temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }
}
