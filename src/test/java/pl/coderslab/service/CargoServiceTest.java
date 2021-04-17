package pl.coderslab.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.model.Cargo;
import pl.coderslab.repository.CargoRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CargoServiceTest {

    @Mock
    private CargoRepository cargoRepository;

    @InjectMocks
    private CargoService cargoService;

    @Test
    public void shouldAdd() {

        Cargo cargo = new Cargo();
        cargo.setId(10L);
        cargo.setName("woda");

        given(cargoRepository.findById(cargo.getId())).willReturn(Optional.of(cargo));

        cargoService.add(cargo);
        Cargo cargo1=cargoService.showById(10L);
        Assertions.assertThat(cargo1.getName()).isEqualTo("woda");

    }

    @Test
    public void shouldUpdateIfExist() {

        Cargo cargo = new Cargo();
        cargo.setId(100L);
        cargo.setName("cukier");

        cargoService.add(cargo);
        given(cargoRepository.findById(cargo.getId())).willReturn(Optional.of(cargo));
        cargo.setName("melasa");

        cargoService.update(cargo);
        Cargo cargo1=cargoService.showById(100L);
        Assertions.assertThat(cargo1.getName()).isEqualTo("melasa");

    }

    @Test(expected = RuntimeException.class)
    public void shouldNotUpadateIfDoesntExist(){
        Cargo cargo = new Cargo();
        cargo.setId(1L);
        cargo.setName("cukier");

        when(cargoRepository.save(cargo)).thenReturn(cargo);

        cargoService.add(cargo);
        cargo.setName("melasa");
        cargoService.delete(1L);
        cargoService.update(cargo);

    }

    @Test
    public void shouldDeleteIfExist() {

        Cargo cargo = new Cargo();
        cargo.setId(1L);
        cargo.setName("cukier");

        when(cargoRepository.findById(cargo.getId())).thenReturn(Optional.of(cargo));

        cargoService.delete(cargo.getId());

        verify(cargoRepository).deleteById(cargo.getId());

    }

    @Test(expected = RuntimeException.class)
    public void shouldDeleteIfDoesntExits() {
        Cargo cargo = new Cargo();
        cargo.setId(2L);
        cargo.setName("melasa");

        given(cargoRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));

        cargoService.delete(cargo.getId());

    }

    @Test
    public void shouldShowAll() {

        List<Cargo> cargos = new ArrayList<>();
        Cargo cargo = new Cargo();
        Cargo cargo1 = new Cargo();
        cargos.add(cargo);
        cargos.add(cargo1);

        given(cargoRepository.findAll()).willReturn(cargos);

        List<Cargo> expected = cargoService.showAll();

        assertEquals(expected, cargos);

        verify(cargoRepository).findAll();
    }


    @Test
    public void ShouldShowById() {
        Cargo cargo = new Cargo();
        cargo.setId(1L);

        when(cargoRepository.save(cargo)).thenReturn(cargo);
        when(cargoRepository.findById(1L)).thenReturn(Optional.of(cargo));

        cargoService.add(cargo);
        Cargo expectedCargo = cargoService.showById(1L);

        assertSame(cargo, expectedCargo);

    }


    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowExceptionWhenIdDoesntExist() {
        Cargo cargo = new Cargo();
        cargo.setId(1L);

        given(cargoRepository.findById(2L)).willReturn(Optional.ofNullable(null));

        Cargo expectedCargo = cargoService.showById(2L);

    }
}