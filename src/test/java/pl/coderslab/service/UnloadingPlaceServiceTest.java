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
import pl.coderslab.model.UnloadingPlace;
import pl.coderslab.repository.UnloadingPlaceRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UnloadingPlaceServiceTest {

    @Mock
    UnloadingPlaceRepository unloadingPlaceRepository;

    @InjectMocks
    UnloadingPlaceService unloadingPlaceService;

    @Test
    public void shouldAdd() {
        UnloadingPlace unloadingPlace = new UnloadingPlace();
        unloadingPlace.setAlias("Barry");
        unloadingPlace.setPlace("Łódź");
        ArgumentCaptor<UnloadingPlace>argumentCaptor=ArgumentCaptor.forClass(UnloadingPlace.class);


        unloadingPlaceService.add(unloadingPlace);


        Mockito.verify(unloadingPlaceRepository).save(argumentCaptor.capture());
        String alias=unloadingPlace.getAlias();
        String place=unloadingPlace.getPlace();
        String addedAlias=argumentCaptor.getValue().getAlias();
        String addedPlace=argumentCaptor.getValue().getPlace();
        Assert.assertSame(alias, addedAlias);
        Assert.assertSame(place, addedPlace);

    }

    @Test
    public void shouldUpdate() {
        UnloadingPlace unloadingPlace = new UnloadingPlace();
        unloadingPlace.setAlias("Barry");
        ArgumentCaptor<UnloadingPlace>argumentCaptor=ArgumentCaptor.forClass(UnloadingPlace.class);
        unloadingPlace.setAlias("CocaCola");


        unloadingPlaceService.update(unloadingPlace);


        Mockito.verify(unloadingPlaceRepository).save(argumentCaptor.capture());
        String updatedAlias=argumentCaptor.getValue().getAlias();
        Assert.assertSame(updatedAlias, "CocaCola");

    }

    @Test
    public void shouldDelete() {
        UnloadingPlace unloadingPlace=new UnloadingPlace();
        unloadingPlace.setId(1L);
        ArgumentCaptor<Long>unloadingPlaceArgumentCaptor=
                ArgumentCaptor.forClass(Long.class);


        unloadingPlaceService.delete(1L);


        Mockito.verify(unloadingPlaceRepository).
        deleteById(unloadingPlaceArgumentCaptor.capture());
        Assert.assertSame(unloadingPlaceArgumentCaptor.getValue(), 1L);
    }

    @Test
    public void shouldShowAll() {
        List<UnloadingPlace>unloadingPlaces=new ArrayList<>();
        UnloadingPlace unloadingPlace1=new UnloadingPlace();
        unloadingPlace1.setPlace("Katowice");
        UnloadingPlace unloadingPlace2=new UnloadingPlace();
        unloadingPlace2.setCountry("Polska");
        UnloadingPlace unloadingPlace3=new UnloadingPlace();
        unloadingPlace3.setAlias("Maspex");
        unloadingPlaces.add(unloadingPlace1);
        unloadingPlaces.add(unloadingPlace2);
        unloadingPlaces.add(unloadingPlace3);
        Mockito.when(unloadingPlaceRepository.findAll()).thenReturn(unloadingPlaces);


        List<UnloadingPlace>allUnlodingPlaces=unloadingPlaceService.showAll();


        String place=allUnlodingPlaces.get(0).getPlace();
        String country=allUnlodingPlaces.get(1).getCountry();
        String alias=allUnlodingPlaces.get(2).getAlias();

        Assert.assertSame(place, "Katowice");
        Assert.assertSame(country, "Polska");
        Assert.assertSame(alias, "Maspex");
    }

    @Test
    public void shouldShowByIdWhenExists() {
        UnloadingPlace unloadingPlace=new UnloadingPlace();
        unloadingPlace.setId(5L);
        given(unloadingPlaceRepository.findById(5L)).willReturn(Optional.of(unloadingPlace));


        UnloadingPlace foundUnloadingPlace=unloadingPlaceService.showById(5L);


        Assertions.assertThat(unloadingPlace).isEqualTo(foundUnloadingPlace);

    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldShowExceptionWhenUnloadingPlaceDoestnExist(){
        //given
        UnloadingPlace unloadingPlace=new UnloadingPlace();
        unloadingPlace.setId(20L);
        given(unloadingPlaceRepository.findById(5L)).willReturn(Optional.ofNullable(null));

        //when
        UnloadingPlace foundUnloadingPlace=unloadingPlaceService.showById(5L);


        //then Exception
    }
}