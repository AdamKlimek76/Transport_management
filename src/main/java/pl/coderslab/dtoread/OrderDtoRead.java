package pl.coderslab.dtoread;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.model.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OrderDtoRead {

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

    @NotNull
    private Driver driver;

    @NotNull
    private Semitrailer semitrailer;

    @NotNull
    private Truck truck;

    public OrderDtoRead(Long id, String status, LocalDateTime created, LocalDateTime updated, String orderNumber, LocalDate deliveryDate, LocalTime deliveryHour, LocalDate loadingDate, LocalTime loadingHour, @NotNull LoadingPlace loadingPlace, @NotNull UnloadingPlace unloadingPlace, @NotNull Cargo cargo, @NotNull Driver driver, @NotNull Semitrailer semitrailer, @NotNull Truck truck) {
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
        this.driver = driver;
        this.semitrailer = semitrailer;
        this.truck = truck;
    }

    public OrderDtoRead(){};

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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Semitrailer getSemitrailer() {
        return semitrailer;
    }

    public void setSemitrailer(Semitrailer semitrailer) {
        this.semitrailer = semitrailer;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    @Override
    public String toString() {
        return "OrderDtoReadBooked{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", orderNumber='" + orderNumber + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", deliveryHour=" + deliveryHour +
                ", loadingDate=" + loadingDate +
                ", loadingHour=" + loadingHour +
                ", loadingPlace=" + loadingPlace +
                ", unloadingPlace=" + unloadingPlace +
                ", cargo=" + cargo +
                ", driver=" + driver +
                ", semitrailer=" + semitrailer +
                ", truck=" + truck +
                '}';
    }
}
