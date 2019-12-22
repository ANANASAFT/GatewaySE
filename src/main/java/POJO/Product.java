package POJO;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Toon
 * @create: 2019-12-20 20:39
 **/
@Entity(name = "product")
public class Product {
    private int id;
    private String model;
    private String intelDeviceProtocol;
    private String uploadProtocol;
    private String industrialGrade;
    private String chargeableBattery;
    private String power;
    private String workEnvironment;
    private String brand;
    private String description;
    private String others;

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
    @Column(name = "intel_device_protocol")
    public String getIntelDeviceProtocol() {
        return intelDeviceProtocol;
    }

    public void setIntelDeviceProtocol(String intelDeviceProtocol) {
        this.intelDeviceProtocol = intelDeviceProtocol;
    }

    @Basic
    @Column(name = "upload_protocol")
    public String getUploadProtocol() {
        return uploadProtocol;
    }

    public void setUploadProtocol(String uploadProtocol) {
        this.uploadProtocol = uploadProtocol;
    }

    @Basic
    @Column(name = "industrial_grade")
    public String getIndustrialGrade() {
        return industrialGrade;
    }

    public void setIndustrialGrade(String industrialGrade) {
        this.industrialGrade = industrialGrade;
    }

    @Basic
    @Column(name = "chargeable_battery")
    public String getChargeableBattery() {
        return chargeableBattery;
    }

    public void setChargeableBattery(String chargeableBattery) {
        this.chargeableBattery = chargeableBattery;
    }

    @Basic
    @Column(name = "power")
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Basic
    @Column(name = "work_environment")
    public String getWorkEnvironment() {
        return workEnvironment;
    }

    public void setWorkEnvironment(String workEnvironment) {
        this.workEnvironment = workEnvironment;
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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "others")
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (model != null ? !model.equals(product.model) : product.model != null) return false;
        if (intelDeviceProtocol != null ? !intelDeviceProtocol.equals(product.intelDeviceProtocol) : product.intelDeviceProtocol != null)
            return false;
        if (uploadProtocol != null ? !uploadProtocol.equals(product.uploadProtocol) : product.uploadProtocol != null)
            return false;
        if (industrialGrade != null ? !industrialGrade.equals(product.industrialGrade) : product.industrialGrade != null)
            return false;
        if (chargeableBattery != null ? !chargeableBattery.equals(product.chargeableBattery) : product.chargeableBattery != null)
            return false;
        if (power != null ? !power.equals(product.power) : product.power != null) return false;
        if (workEnvironment != null ? !workEnvironment.equals(product.workEnvironment) : product.workEnvironment != null)
            return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (others != null ? !others.equals(product.others) : product.others != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (intelDeviceProtocol != null ? intelDeviceProtocol.hashCode() : 0);
        result = 31 * result + (uploadProtocol != null ? uploadProtocol.hashCode() : 0);
        result = 31 * result + (industrialGrade != null ? industrialGrade.hashCode() : 0);
        result = 31 * result + (chargeableBattery != null ? chargeableBattery.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (workEnvironment != null ? workEnvironment.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (others != null ? others.hashCode() : 0);
        return result;
    }
}
