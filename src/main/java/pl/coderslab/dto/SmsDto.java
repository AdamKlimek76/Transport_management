package pl.coderslab.dto;


import pl.coderslab.model.Driver;

import javax.validation.constraints.NotNull;

public class SmsDto {

    private Long id;

    @NotNull
    private String message;

    @NotNull
    private Driver driver;

    public SmsDto(Long id, @NotNull String message, @NotNull Driver driver) {
        this.id = id;
        this.message = message;
        this.driver = driver;
    }

    public SmsDto() { }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
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
}
