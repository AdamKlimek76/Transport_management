package pl.coderslab.dto;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.model.Cargo;
import pl.coderslab.model.LoadingPlace;
import pl.coderslab.model.UnloadingPlace;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrderDtoNew {

    private Long id;

    private String status;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime deliveryHour;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate loadingDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime loadingHour;

    @NotNull
    private LoadingPlace loadingPlace;

    @NotNull
    private UnloadingPlace unloadingPlace;

    @NotNull
    private Cargo cargo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalTime getDeliveryHour() {
        return deliveryHour;
    }

    public void setDeliveryHour(LocalTime deliveryHour) {
        this.deliveryHour = deliveryHour;
    }

    public LocalDate getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(LocalDate loadingDate) {
        this.loadingDate = loadingDate;
    }

    public LocalTime getLoadingHour() {
        return loadingHour;
    }

    public void setLoadingHour(LocalTime loadingHour) {
        this.loadingHour = loadingHour;
    }

    public LoadingPlace getLoadingPlace() {
        return loadingPlace;
    }

    public void setLoadingPlace(LoadingPlace loadingPlace) {
        this.loadingPlace = loadingPlace;
    }

    public UnloadingPlace getUnloadingPlace() {
        return unloadingPlace;
    }

    public void setUnloadingPlace(UnloadingPlace unloadingPlace) {
        this.unloadingPlace = unloadingPlace;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
