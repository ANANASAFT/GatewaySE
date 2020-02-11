package POJO;

/**
 * @author: Toon
 * @create: 2020-02-10 18:36
 **/
public class SensorWorkingEnv {
    int industrial_grade;
    float temperatureLow;
    float temperatureHigh;
    float voltageLow;
    float voltageHigh;
    float frequencyLow;
    float frequencyHigh;
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

    public float getVoltageLow() {
        return voltageLow;
    }

    public void setVoltageLow(float voltageLow) {
        this.voltageLow = voltageLow;
    }

    public float getVoltageHigh() {
        return voltageHigh;
    }

    public void setVoltageHigh(float voltageHigh) {
        this.voltageHigh = voltageHigh;
    }

    public float getFrequencyLow() {
        return frequencyLow;
    }

    public void setFrequencyLow(float frequencyLow) {
        this.frequencyLow = frequencyLow;
    }

    public float getFrequencyHigh() {
        return frequencyHigh;
    }

    public void setFrequencyHigh(float frequencyHigh) {
        this.frequencyHigh = frequencyHigh;
    }

    public float getCurrent() {
        return current;
    }

    public void setCurrent(float current) {
        this.current = current;
    }
}
