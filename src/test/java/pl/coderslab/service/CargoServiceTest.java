package pl.coderslab.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.model.Cargo;
import pl.coderslab.repository.CargoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
        Cargo cargo1=cargoService.showById(10L).orElseThrow();
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
        Cargo cargo1=cargoService.showById(100L).orElseThrow();
        Assertions.assertThat(cargo1.getName()).isEqualTo("melasa");

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
    public void showById() {
    }
}