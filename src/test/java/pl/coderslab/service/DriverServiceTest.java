package pl.coderslab.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.model.Cargo;
import pl.coderslab.model.Driver;
import pl.coderslab.repository.DriverRepository;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DriverServiceTest {

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverService driverService;

    @Test
    public void shouldAdd() {

        Driver driver = new Driver();
        driver.setId(1L);
        driver.setFirstName("Adam");
        driver.setLastName("Klim");
        driver.setPhoneNumber("123123123");
        driver.setSalary(3000.0);

        given(driverRepository.findById(driver.getId())).willReturn(Optional.of(driver));

        driverService.add(driver);
        Driver driver1 = driverService.showById(1L).orElseThrow();
        //Assertions.assertThat(driver1.getFirstName()).isEqualTo("Adam");
        assertSame(driver, driver1);
    }

    @Test
    public void shouldUpdateIfExist() {
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setFirstName("Adam");
        driver.setLastName("Klim");
        driver.setPhoneNumber("123123123");
        driver.setSalary(3000.0);

        driverService.add(driver);
        given(driverRepository.findById(driver.getId())).willReturn(Optional.of(driver));
        driver.setFirstName("Ewelina");
        driver.setLastName("Klimek");

        driverService.update(driver);
        Driver driver1 = driverService.showById(1L).orElseThrow();
        Assertions.assertThat(driver.getFirstName()).isEqualTo("Ewelina");
        Assertions.assertThat(driver.getLastName()).isEqualTo("Klimek");

    }

    @Test
    public void shouldDelete() {
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setFirstName("Adam");
        driver.setLastName("Klim");
        driver.setSalary(3000.0);
        driver.setPhoneNumber("123456789");


        when(driverRepository.findById(driver.getId())).thenReturn(Optional.of(driver));

        driverService.delete(driver.getId());

        verify(driverRepository).deleteById(driver.getId());
    }

    @Test
    public void showAll() {
        List<Driver> drivers = new ArrayList<>();
        Driver driver = new Driver();
        Driver driver1 = new Driver();
        Driver driver2 = new Driver();
        drivers.add(driver);
        drivers.add(driver1);
        drivers.add(driver2);

        given(driverRepository.findAll()).willReturn(drivers);

        List<Driver> expected = driverService.showAll();

        assertEquals(expected, drivers);

        //verify(driverRepository).findAll();
    }

    @Test
    public void showById() {
    }
}