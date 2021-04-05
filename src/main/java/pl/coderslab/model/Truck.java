package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="trucks")
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=7, max=7)
    private String registerNumber;
    @NotNull
    private String brand;
    @Min(1980)
    @Max(2021)//tu dodać aktualny rok
    private Long productionYear;
    @Min(20)
    @Max(50)
    private Double fuelConsumption;

    public Truck(@Size(min = 7, max = 7) String registerNumber, @NotNull String brand, @Min(1980) @Max(2021) Long productionYear, @Min(20) @Max(50) Double fuelConsumption) {
        this.registerNumber = registerNumber;
        this.brand = brand;
        this.productionYear = productionYear;
        this.fuelConsumption = fuelConsumption;
    }


    public Truck(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Long productionYear) {
        this.productionYear = productionYear;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", registerNumber='" + registerNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", fuelConsumption=" + fuelConsumption +
                '}';
    }
}
