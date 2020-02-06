package POJO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Toon
 * @create: 2020-02-06 15:13
 **/
@Entity(name = "gateway")
public class Gateway {
    private int id;
    private String model;
    private String brand;
    private Double temperatureHigh;
    private Double temperatureLow;
    private Double current;
    private Integer industrialGrade;
    private Integer intelDeviceInterface;
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
    @Column(name = "temperature_high")
    public Double getTemperatureHigh() {
        return temperatureHigh;
    }

    public void setTemperatureHigh(Double temperatureHigh) {
        this.temperatureHigh = temperatureHigh;
    }

    @Basic
    @Column(name = "temperature_low")
    public Double getTemperatureLow() {
        return temperatureLow;
    }

    public void setTemperatureLow(Double temperatureLow) {
        this.temperatureLow = temperatureLow;
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
    @Column(name = "industrial_grade")
    public Integer getIndustrialGrade() {
        return industrialGrade;
    }

    public void setIndustrialGrade(Integer industrialGrade) {
        this.industrialGrade = industrialGrade;
    }

    @Basic
    @Column(name = "intel_device_interface")
    public Integer getIntelDeviceInterface() {
        return intelDeviceInterface;
    }

    public void setIntelDeviceInterface(Integer intelDeviceInterface) {
        this.intelDeviceInterface = intelDeviceInterface;
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

        Gateway gateway = (Gateway) o;

        if (id != gateway.id) return false;
        if (model != null ? !model.equals(gateway.model) : gateway.model != null) return false;
        if (brand != null ? !brand.equals(gateway.brand) : gateway.brand != null) return false;
        if (temperatureHigh != null ? !temperatureHigh.equals(gateway.temperatureHigh) : gateway.temperatureHigh != null)
            return false;
        if (temperatureLow != null ? !temperatureLow.equals(gateway.temperatureLow) : gateway.temperatureLow != null)
            return false;
        if (current != null ? !current.equals(gateway.current) : gateway.current != null) return false;
        if (industrialGrade != null ? !industrialGrade.equals(gateway.industrialGrade) : gateway.industrialGrade != null)
            return false;
        if (intelDeviceInterface != null ? !intelDeviceInterface.equals(gateway.intelDeviceInterface) : gateway.intelDeviceInterface != null)
            return false;
        if (description != null ? !description.equals(gateway.description) : gateway.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (temperatureHigh != null ? temperatureHigh.hashCode() : 0);
        result = 31 * result + (temperatureLow != null ? temperatureLow.hashCode() : 0);
        result = 31 * result + (current != null ? current.hashCode() : 0);
        result = 31 * result + (industrialGrade != null ? industrialGrade.hashCode() : 0);
        result = 31 * result + (intelDeviceInterface != null ? intelDeviceInterface.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
