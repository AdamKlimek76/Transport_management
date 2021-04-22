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
        given(loadingPlaceRepositoryMock.findById(2L)).willReturn(Optional.of(loadingPlace));

        //when
        loadingPlaceService.add(loadingPlace);

        //then
        LoadingPlace addedLoadingPlace = loadingPlaceService.showById(2L);
        assertSame(addedLoadingPlace, loadingPlace);
    }


    @Test
    public void shouldAddByArgumentsCapturing() {
        //given
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

        //when
        loadingPlaceService.add(loadingPlace);

        //then
        verify(loadingPlaceRepositoryMock).save(loadingPlaceArgumentCaptor.capture());
        LoadingPlace addedLoadingPlace = loadingPlaceService.showById(5L);
        String alias = addedLoadingPlace.getAlias();
        String aliasCaptured = loadingPlaceArgumentCaptor.getValue().getAlias();
        assertSame(alias, aliasCaptured);
    }

    @Test
    public void shouldUpdate() {
        //given
        LoadingPlace loadingPlace = new LoadingPlace();
        loadingPlace.setCompany("firma");
        loadingPlace.setId(10L);
        LoadingPlace loadingPlaceToUpdate = new LoadingPlace();
        loadingPlaceToUpdate.setId(loadingPlace.getId());
        loadingPlaceToUpdate.setCompany("firma1");
        given(loadingPlaceRepositoryMock.findById(loadingPlace.getId())).willReturn(Optional.of(loadingPlace));

        //when
        loadingPlaceService.update(loadingPlaceToUpdate);

        //then
        verify(loadingPlaceRepositoryMock).save(loadingPlaceToUpdate);

    }

    @Test
    public void shouldDelete() {
        //given
        LoadingPlace loadingPlace = new LoadingPlace();
        loadingPlace.setId(1L);
        when(loadingPlaceRepositoryMock.findById(loadingPlace.getId())).thenReturn(Optional.of(loadingPlace));

        //when
        loadingPlaceService.delete(loadingPlace.getId());

        //then
        verify(loadingPlaceRepositoryMock).deleteById(loadingPlace.getId());

    }

    @Test
    public void shouldShowAll() {
        //given
        List<LoadingPlace> loadingPlacesMock = List.of(new LoadingPlace(), new LoadingPlace());
        when(loadingPlaceRepositoryMock.findAll()).thenReturn(loadingPlacesMock);

        //when
        List<LoadingPlace> loadingPlaces = loadingPlaceService.showAll();

        //then
        Assertions.assertThat(loadingPlacesMock).containsAll(loadingPlaces);
    }

    @Test
    public void shouldShowByIdIfEntityExist() {
        //given
        LoadingPlace loadingPlace = new LoadingPlace();
        loadingPlace.setId(10L);
        given(loadingPlaceRepositoryMock.findById(10L)).willReturn(Optional.of(loadingPlace));

        //when
        LoadingPlace foundLoadingPlace = loadingPlaceService.showById(10L);

        //then
        assertSame(foundLoadingPlace, loadingPlace);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldShowExceptionIfEntityDoesntExist(){
        //given
        LoadingPlace loadingPlace = new LoadingPlace();
        given(loadingPlaceRepositoryMock.findById(1L)).willReturn(Optional.ofNullable(null));

        //when
        LoadingPlace foundLoadingPlace = loadingPlaceService.showById(1L);

        //then Exception
    }
}