package pl.coderslab.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "new_orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    private String status="nowe";

    @CreatedDate
    private LocalDateTime created = LocalDateTime.now();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deliveryDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime deliveryHour;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate loadingDate;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime loadingHour;

    @ManyToOne
    @NotNull
    private LoadingPlace loadingPlace;

    @ManyToOne
    @NotNull
    private UnloadingPlace unloadingPlace;

    @ManyToOne
    @NotNull
    private Cargo cargo;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Truck truck;

    @ManyToOne
    private Semitrailer semitrailer;

    public Order(String orderNumber, String status, LocalDateTime created, LocalDate deliveryDate, LocalTime deliveryHour, LocalDate loadingDate, LocalTime loadingHour, @NotNull LoadingPlace loadingPlace, @NotNull UnloadingPlace unloadingPlace, @NotNull Cargo cargo, Driver driver, Truck truck, Semitrailer semitrailer) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.created = created;
        this.deliveryDate = deliveryDate;
        this.deliveryHour = deliveryHour;
        this.loadingDate = loadingDate;
        this.loadingHour = loadingHour;
        this.loadingPlace = loadingPlace;
        this.unloadingPlace = unloadingPlace;
        this.cargo = cargo;
        this.driver = driver;
        this.truck = truck;
        this.semitrailer = semitrailer;
    }

    public Order(){};

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

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Semitrailer getSemitrailer() {
        return semitrailer;
    }

    public void setSemitrailer(Semitrailer semitrailer) {
        this.semitrailer = semitrailer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", status='" + status + '\'' +
                ", created=" + created +
                ", deliveryDate=" + deliveryDate +
                ", deliveryHour=" + deliveryHour +
                ", loadingDate=" + loadingDate +
                ", loadingHour=" + loadingHour +
                ", loadingPlace=" + loadingPlace +
                ", unloadingPlace=" + unloadingPlace +
                ", cargo=" + cargo +
                ", driver=" + driver +
                ", truck=" + truck +
                ", semitrailer=" + semitrailer +
                '}';
    }
}
