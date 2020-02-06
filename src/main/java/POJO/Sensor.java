package POJO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Toon
 * @create: 2020-02-06 15:13
 **/
@Entity(name = "sensor")
public class Sensor {
    private int id;
    private String model;
    private String brand;
    private Integer function;
    private Double voltageHigh;
    private Double voltageLow;
    private Double current;
    private Integer temperatureHigh;
    private Integer temperatureLow;
    private Integer frequencyHigh;
    private Integer frequencyLow;
    private Integer outputInterface;
    private Integer industrialGrade;
    private String description;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "function")
    public Integer getFunction() {
        return function;
    }

    public void setFunction(Integer function) {
        this.function = function;
    }

    @Basic
    @Column(name = "voltage_high")
    public Double getVoltageHigh() {
        return voltageHigh;
    }

    public void setVoltageHigh(Double voltageHigh) {
        this.voltageHigh = voltageHigh;
    }

    @Basic
    @Column(name = "voltage_low")
    public Double getVoltageLow() {
        return voltageLow;
    }

    public void setVoltageLow(Double voltageLow) {
        this.voltageLow = voltageLow;
    }

    @Basic
    @Column(name = "current")
    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    @Basic
    @Column(name = "temperature_high")
    public Integer getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(Integer temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    @Basic
    @Column(name = "temperature_low")
    public Integer getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(Integer temperatureLow) {
        this.temperatureLow = temperatureLow;
    }

    @Basic
    @Column(name = "frequency_high")
    public Integer getFrequencyHigh() {
        return frequencyHigh;
    }

    public void setFrequencyHigh(Integer frequencyHigh) {
        this.frequencyHigh = frequencyHigh;
    }

    @Basic
    @Column(name = "frequency_low")
    public Integer getFrequencyLow() {
        return frequencyLow;
    }

    public void setFrequencyLow(Integer frequencyLow) {
        this.frequencyLow = frequencyLow;
    }

    @Basic
    @Column(name = "output_interface")
    public Integer getOutputInterface() {
        return outputInterface;
    }

    public void setOutputInterface(Integer outputInterface) {
        this.outputInterface = outputInterface;
    }

    @Basic
    @Column(name = "industrial_grade")
    public Integer getIndustrialGrade() {
        return industrialGrade;
    }

    public void setIndustrialGrade(Integer industrialGrade) {
        this.industrialGrade = industrialGrade;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensor sensor = (Sensor) o;

        if (id != sensor.id) return false;
        if (model != null ? !model.equals(sensor.model) : sensor.model != null) return false;
        if (brand != null ? !brand.equals(sensor.brand) : sensor.brand != null) return false;
        if (function != null ? !function.equals(sensor.function) : sensor.function != null) return false;
        if (voltageHigh != null ? !voltageHigh.equals(sensor.voltageHigh) : sensor.voltageHigh != null) return false;
        if (voltageLow != null ? !voltageLow.equals(sensor.voltageLow) : sensor.voltageLow != null) return false;
        if (current != null ? !current.equals(sensor.current) : sensor.current != null) return false;
        if (temperatureHigh != null ? !temperatureHigh.equals(sensor.temperatureHigh) : sensor.temperatureHigh != null)
            return false;
        if (temperatureLow != null ? !temperatureLow.equals(sensor.temperatureLow) : sensor.temperatureLow != null)
            return false;
        if (frequencyHigh != null ? !frequencyHigh.equals(sensor.frequencyHigh) : sensor.frequencyHigh != null)
            return false;
        if (frequencyLow != null ? !frequencyLow.equals(sensor.frequencyLow) : sensor.frequencyLow != null)
            return false;
        if (outputInterface != null ? !outputInterface.equals(sensor.outputInterface) : sensor.outputInterface != null)
            return false;
        if (industrialGrade != null ? !industrialGrade.equals(sensor.industrialGrade) : sensor.industrialGrade != null)
            return false;
        if (description != null ? !description.equals(sensor.description) : sensor.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (function != null ? function.hashCode() : 0);
        result = 31 * result + (voltageHigh != null ? voltageHigh.hashCode() : 0);
        result = 31 * result + (voltageLow != null ? voltageLow.hashCode() : 0);
        result = 31 * result + (current != null ? current.hashCode() : 0);
        result = 31 * result + (temperatureHigh != null ? temperatureHigh.hashCode() : 0);
        result = 31 * result + (temperatureLow != null ? temperatureLow.hashCode() : 0);
        result = 31 * result + (frequencyHigh != null ? frequencyHigh.hashCode() : 0);
        result = 31 * result + (frequencyLow != null ? frequencyLow.hashCode() : 0);
        result = 31 * result + (outputInterface != null ? outputInterface.hashCode() : 0);
        result = 31 * result + (industrialGrade != null ? industrialGrade.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
