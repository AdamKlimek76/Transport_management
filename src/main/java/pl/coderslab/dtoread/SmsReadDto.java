package pl.coderslab.dtoread;

import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.model.Driver;

import java.time.LocalDateTime;

public class SmsReadDto {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime created;

    private String message;

    private Driver driver;

    public SmsReadDto(Long id, LocalDateTime created, String message, Driver driver) {
        this.id = id;
        this.created = created;
        this.message = message;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getMessage() {
        return message;
    }

    public Driver getDriver() {
        return driver;
    }
}
