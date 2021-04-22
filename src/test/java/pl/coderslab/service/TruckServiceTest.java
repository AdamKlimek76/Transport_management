package pl.coderslab.service;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.model.Truck;
import pl.coderslab.repository.TruckRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TruckServiceTest {

    @Mock
    TruckRepository truckRepository;

    @InjectMocks
    TruckService truckService;

    @Test
    public void shouldAdd() {
        Truck truck=new Truck();
        truck.setBrand("Volvo");
        ArgumentCaptor<Truck>argumentCaptor=ArgumentCaptor.forClass(Truck.class);


        truckService.add(truck);


        Mockito.verify(truckRepository).save(argumentCaptor.capture());
        String brand=truck.getBrand();
        String addedBrand=argumentCaptor.getValue().getBrand();
        Assertions.assertThat(brand).isEqualTo(addedBrand);

    }

    @Test
    public void shouldUpdate() {
        Truck truck=new Truck();
        truck.setBrand("Volvo");
        truck.setRegisterNumber("SBI3498");
        ArgumentCaptor<Truck>argumentCaptor=ArgumentCaptor.forClass(Truck.class);


        truckService.update(truck);


        Mockito.verify(truckRepository).save(argumentCaptor.capture());
        String registerNumber=truck.getRegisterNumber();
        String updatedRegisterNumber=argumentCaptor.getValue().getRegisterNumber();
        Assertions.assertThat(registerNumber).isEqualTo(updatedRegisterNumber);
    }

    @Test
    public void shouldDelete() {
        Truck truck=new Truck();
        truck.setBrand("Volvo");
        truck.setRegisterNumber("SBI3498");
        truck.setId(20L);
        ArgumentCaptor<Long>argumentCaptor=ArgumentCaptor.forClass(Long.class);


        truckService.delete(truck.getId());


        Mockito.verify(truckRepository).deleteById(argumentCaptor.capture());
        Long truckId =truck.getId();
        Long deletedTruckId=argumentCaptor.getValue();
        Assertions.assertThat(truckId).isEqualTo(deletedTruckId);
    }

    @Test
    public void shouldShowAll() {
        List<Truck>trucks=new ArrayList<>();
        trucks.add(new Truck());
        trucks.add(new Truck());
        trucks.add(new Truck());
        Mockito.when(truckRepository.findAll()).thenReturn(trucks);


        List<Truck>foundTrucks=truckService.showAll();


        Assertions.assertThat(foundTrucks).containsAll(trucks);

    }

    @Test
    public void shouldShowByIdWhenTruckExist() {
        Truck truck = new Truck();
        truck.setId(100L);
        given(truckRepository.findById(100L)).willReturn(Optional.of(truck));


        Truck foundTruck=truckService.showById(100L);


        Assert.assertSame(truck, foundTruck);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldShowExceptionsWhenIdDoesntExist(){
        //given
        Truck truck = new Truck();
        truck.setId(10L);
        given(truckRepository.findById(20L)).willReturn(Optional.ofNullable(null));

        //when
        Truck foundTruck=truckService.showById(20L);

        //given Exception

    }
}