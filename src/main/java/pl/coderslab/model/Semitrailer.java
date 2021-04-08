package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="semitrailers")
public class Semitrailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min=7, max=7)
    private String registerNumber;
    @NotEmpty
    private String brand;
    @Min(1980)
    @Max(2021)//tu dodać aktualny rok
    private Long productionYear;
    @NotEmpty
    private String type;

    public Semitrailer(@Size(min = 7, max = 7) String registerNumber, @NotEmpty String brand, @Min(1980) @Max(2021) Long productionYear, @NotEmpty String type) {
        this.registerNumber = registerNumber;
        this.brand = brand;
        this.productionYear = productionYear;
        this.type = type;
    }

    public Semitrailer(){};

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Semitrailer{" +
                "id=" + id +
                ", registerNumber='" + registerNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", type='" + type + '\'' +
                '}';
    }
}
