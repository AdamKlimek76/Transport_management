package pl.coderslab.dtoread;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.model.Cargo;
import pl.coderslab.model.LoadingPlace;
import pl.coderslab.model.UnloadingPlace;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OrderReadNewDto {

    private Long id;

    private String status;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String orderNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime deliveryHour;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate loadingDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime loadingHour;

    @NotNull
    private LoadingPlace loadingPlace;

    @NotNull
    private UnloadingPlace unloadingPlace;

    @NotNull
    private Cargo cargo;


    public OrderReadNewDto(Long id, String status, LocalDateTime created, LocalDateTime updated, String orderNumber, LocalDate deliveryDate, LocalTime deliveryHour, LocalDate loadingDate, LocalTime loadingHour, LoadingPlace loadingPlace, UnloadingPlace unloadingPlace, Cargo cargo) {
        this.id = id;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.orderNumber = orderNumber;
        this.deliveryDate = deliveryDate;
        this.deliveryHour = deliveryHour;
        this.loadingDate = loadingDate;
        this.loadingHour = loadingHour;
        this.loadingPlace = loadingPlace;
        this.unloadingPlace = unloadingPlace;
        this.cargo = cargo;
    }


    public OrderReadNewDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
