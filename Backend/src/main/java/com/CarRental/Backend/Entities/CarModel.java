package com.CarRental.Backend.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String Make;
    private String Model;
    private String Version;
    private String Type;
    private Long Gross;
    private Long Nett;
    private Long Co2Emission;
    private Long Distance;
    private Long Mileage;
    private boolean Available;

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + id +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", Version='" + Version + '\'' +
                ", Type='" + Type + '\'' +
                ", Gross=" + Gross +
                ", Nett=" + Nett +
                ", Co2Emission=" + Co2Emission +
                '}';
    }

    public CarModel(Long id, String make, String model, String version, String type, Long gross, Long nett, Long co2Emission, Long distance, Long mileage, boolean available) {
        this.id = id;
        Make = make;
        Model = model;
        Version = version;
        Type = type;
        Gross = gross;
        Nett = nett;
        Co2Emission = co2Emission;
        Distance=distance;
        Mileage=mileage;
        Available=available;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }

    public  CarModel(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDistance() {
        return Distance;
    }

    public void setDistance(Long distance) {
        Distance = distance;
    }

    public Long getMileage() {
        return Mileage;
    }

    public void setMileage(Long mileage) {
        Mileage = mileage;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Long getGross() {
        return Gross;
    }

    public void setGross(Long gross) {
        Gross = gross;
    }

    public Long getNett() {
        return Nett;
    }

    public void setNett(Long nett) {
        Nett = nett;
    }

    public Long getCo2Emission() {
        return Co2Emission;
    }

    public void setCo2Emission(Long co2Emission) {
        Co2Emission = co2Emission;
    }
}
