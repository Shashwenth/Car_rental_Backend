package com.CarRental.Backend.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="carId")
    private  Long carId;
    private String carMake;
    private String carModel;
    private String carVersion;
    private String carType;
    private Long carGross;
    private Long carNett;
    private Long carCo2Emission;
    private Long carDistance;
    private Long carMileage;
    private boolean carAvailable;

    @OneToOne(mappedBy = "carModel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("CarModelReference")
    private Lease carLeasedTo;

    public Lease getCarLeasedTo() {
        return carLeasedTo;
    }

    public void setCarLeasedTo(Lease carLeasedTo) {
        this.carLeasedTo = carLeasedTo;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id=" + carId +
                ", Make='" + carMake + '\'' +
                ", Model='" + carModel + '\'' +
                ", Version='" + carVersion + '\'' +
                ", Type='" + carType + '\'' +
                ", Gross=" + carGross +
                ", Nett=" + carNett +
                ", Co2Emission=" + carCo2Emission +
                '}';
    }

    public CarModel(Long carId, String carMake, String carModel, String carVersion, String carType, Long carGross, Long carNett, Long carCo2Emission, Long carDistance, Long carMileage, boolean carAvailable) {
        this.carId = carId;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carVersion = carVersion;
        this.carType = carType;
        this.carGross = carGross;
        this.carNett = carNett;
        this.carCo2Emission = carCo2Emission;
        this.carDistance = carDistance;
        this.carMileage = carMileage;
        this.carAvailable = carAvailable;
    }

    public boolean isCarAvailable() {
        return carAvailable;
    }

    public void setCarAvailable(boolean carAvailable) {
        this.carAvailable = carAvailable;
    }

    public  CarModel(){
        super();
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCarDistance() {
        return carDistance;
    }

    public void setCarDistance(Long carDistance) {
        this.carDistance = carDistance;
    }

    public Long getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(Long carMileage) {
        this.carMileage = carMileage;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarVersion() {
        return carVersion;
    }

    public void setCarVersion(String carVersion) {
        this.carVersion = carVersion;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Long getCarGross() {
        return carGross;
    }

    public void setCarGross(Long carGross) {
        this.carGross = carGross;
    }

    public Long getCarNett() {
        return carNett;
    }

    public void setCarNett(Long carNett) {
        this.carNett = carNett;
    }

    public Long getCarCo2Emission() {
        return carCo2Emission;
    }

    public void setCarCo2Emission(Long carCo2Emission) {
        this.carCo2Emission = carCo2Emission;
    }
}
