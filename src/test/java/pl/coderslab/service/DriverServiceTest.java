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

import javax.persistence.EntityNotFoundException;
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
        Driver addedDriver = driverService.showById(1L);
        assertSame(driver, addedDriver);
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
        Driver updatedDriver = driverService.showById(1L);
        Assertions.assertThat(updatedDriver.getFirstName()).isEqualTo("Ewelina");
        Assertions.assertThat(updatedDriver.getLastName()).isEqualTo("Klimek");

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
    public void shouldShowAll() {
        List<Driver> drivers = new ArrayList<>();
        Driver driver = new Driver();
        Driver driver1 = new Driver();
        Driver driver2 = new Driver();
        drivers.add(driver);
        drivers.add(driver1);
        drivers.add(driver2);

        given(driverRepository.findAll()).willReturn(drivers);

        List<Driver> expectedDrivers = driverService.showAll();

        assertEquals(expectedDrivers, drivers);

    }

    @Test
    public void ShouldShowById() {
        Driver driver1 = new Driver();
        Driver driver2=new Driver();

        given(driverRepository.findById(1L)).willReturn(Optional.of(driver1));
        given(driverRepository.findById(2L)).willReturn(Optional.of(driver2));

        Driver expectedDriver1 = driverService.showById(1L);
        Driver expectedDriver2 = driverService.showById(2L);

        assertSame(driver1, expectedDriver1);
        assertSame(driver2, expectedDriver2);
    }


    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowExeptionWhenIdDoesntExist() {
        Driver driver1 = new Driver();
        Driver driver2=new Driver();

        given(driverRepository.findById(1L)).willReturn(Optional.of(driver1));
        given(driverRepository.findById(2L)).willReturn(Optional.of(driver2));

        Driver expectedDriver1 = driverService.showById(3L);

    }
}