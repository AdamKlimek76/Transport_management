package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name="smses")
public class Sms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created;

    @NotNull
    private String message;

    @ManyToOne
    private Driver driver;

    public Sms(LocalDateTime created, @NotNull String message, Driver driver) {
        this.created = created;
        this.message = message;
        this.driver = driver;
    }

    public Sms(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "id=" + id +
                ", created=" + created +
                ", message='" + message + '\'' +
                ", driver=" + driver +
                '}';
    }
}
