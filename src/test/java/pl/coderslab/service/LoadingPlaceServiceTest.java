package pl.coderslab.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.model.LoadingPlace;
import pl.coderslab.repository.LoadingPlaceRepository;

import javax.crypto.spec.OAEPParameterSpec;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoadingPlaceServiceTest {

    private LoadingPlaceRepository loadingPlaceRepositoryMock = mock(LoadingPlaceRepository.class);
    private LoadingPlaceService loadingPlaceService = new LoadingPlaceService(loadingPlaceRepositoryMock);

    @Test
    public void shouldAdd() {
        //given
        LoadingPlace loadingPlace = new LoadingPlace("firma", "43-433", "Strumień", "Strumień", "Polska", "firmatestowa");
        loadingPlace.setId(2L);

        //when
        given(loadingPlaceRepositoryMock.findById(2L)).willReturn(Optional.of(loadingPlace));
        loadingPlaceService.add(loadingPlace);

        //then
        LoadingPlace addedLoadingPlace = loadingPlaceService.showById(2L);
        assertSame(addedLoadingPlace, loadingPlace);
    }


    @Test
    public void shouldAddSecondWay() {
        LoadingPlace loadingPlace = new LoadingPlace();
        loadingPlace.setId(5L);
        loadingPlace.setAlias("Strzelin");
        loadingPlace.setCompany("Cukrownia Strzelin");
        loadingPlace.setCountry("Polska");
        loadingPlace.setPostCode("11-111");
        loadingPlace.setPost("Strzelin");
        loadingPlace.setPlace("Strzelin");

        ArgumentCaptor<LoadingPlace> loadingPlaceArgumentCaptor = ArgumentCaptor.forClass(LoadingPlace.class);

        given(loadingPlaceRepositoryMock.findById(5L)).willReturn(Optional.of(loadingPlace));
        loadingPlaceService.add(loadingPlace);

        verify(loadingPlaceRepositoryMock).save(loadingPlaceArgumentCaptor.capture());
        LoadingPlace addedLoadingPlace = loadingPlaceService.showById(5L);
        String alias = addedLoadingPlace.getAlias();
        String aliasCaptured = loadingPlaceArgumentCaptor.getValue().getAlias();
        assertSame(alias, aliasCaptured);
    }

    @Test
    public void shouldUpdate() {
        LoadingPlace loadingPlace = new LoadingPlace();
        loadingPlace.setCompany("firma");
        loadingPlace.setId(10L);

        LoadingPlace loadingPlaceToUpdate = new LoadingPlace();
        loadingPlaceToUpdate.setId(loadingPlace.getId());
        loadingPlaceToUpdate.setCompany("firma1");

        given(loadingPlaceRepositoryMock.findById(loadingPlace.getId())).willReturn(Optional.of(loadingPlace));

        loadingPlaceService.update(loadingPlaceToUpdate);

        verify(loadingPlaceRepositoryMock).save(loadingPlaceToUpdate);

    }

    @Test
    public void delete() {
        LoadingPlace loadingPlace = new LoadingPlace();
        loadingPlace.setId(1L);

        when(loadingPlaceRepositoryMock.findById(loadingPlace.getId())).thenReturn(Optional.of(loadingPlace));

        loadingPlaceService.delete(loadingPlace.getId());

        verify(loadingPlaceRepositoryMock).deleteById(loadingPlace.getId());



    }

    @Test
    public void shouldShowAll() {
        List<LoadingPlace> loadingPlacesMock = List.of(new LoadingPlace(), new LoadingPlace());

        when(loadingPlaceRepositoryMock.findAll()).thenReturn(loadingPlacesMock);

        List<LoadingPlace> loadingPlaces = loadingPlaceService.showAll();

        Assertions.assertThat(loadingPlacesMock).containsAll(loadingPlaces);
    }

    @Test
    public void shouldShowByIdIfEntityExist() {

        LoadingPlace loadingPlace = new LoadingPlace();
        loadingPlace.setId(10L);

        given(loadingPlaceRepositoryMock.findById(10L)).willReturn(Optional.of(loadingPlace));

        LoadingPlace foundLoadingPlace = loadingPlaceService.showById(10L);

        assertSame(foundLoadingPlace, loadingPlace);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldShowExceptionIfEntityDoesntExist(){
        LoadingPlace loadingPlace = new LoadingPlace();

        given(loadingPlaceRepositoryMock.findById(1L)).willReturn(Optional.ofNullable(null));

        LoadingPlace foundLoadingPlace = loadingPlaceService.showById(1L);
    }
}