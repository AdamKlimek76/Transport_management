package pl.coderslab.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.model.Semitrailer;
import pl.coderslab.repository.SemitrailerRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SemitrailerServiceTest {

    @Mock
    SemitrailerRepository semitrailerRepository;

    @InjectMocks
    private SemitrailerService semitrailerService;


    @Test
    public void shouldAdd() {
        Semitrailer semitrailer = new Semitrailer();
        semitrailer.setId(1L);
        semitrailer.setBrand("lag");
        semitrailer.setProductionYear(2010L);
        semitrailer.setRegisterNumber("SCI1234");
        semitrailer.setType("silos");

        ArgumentCaptor<Semitrailer>argumentCaptor=ArgumentCaptor.forClass(Semitrailer.class);
        semitrailerService.add(semitrailer);

        verify(semitrailerRepository).save(argumentCaptor.capture());
        String brand=semitrailer.getBrand();
        String savedBrand=argumentCaptor.getValue().getBrand();
        Assertions.assertThat(brand).isEqualTo(savedBrand);

    }

    @Test
    public void shouldUpdate() {
        Semitrailer semitrailer = new Semitrailer();
        semitrailer.setId(1L);
        semitrailer.setBrand("lag");
        semitrailer.setProductionYear(2010L);
        semitrailer.setRegisterNumber("SCI1234");
        semitrailer.setType("silos");

        ArgumentCaptor<Semitrailer>argumentCaptor=ArgumentCaptor.forClass(Semitrailer.class);
        semitrailerService.update(semitrailer);


        verify(semitrailerRepository).save(argumentCaptor.capture());
        String brand=semitrailer.getBrand();
        String updatedBrand=argumentCaptor.getValue().getBrand();
        Assertions.assertThat(brand).isEqualTo(updatedBrand);

    }

    @Test
    public void shouldDelete() {
        Semitrailer semitrailer = new Semitrailer();
        semitrailer.setId(1L);
        semitrailer.setBrand("lag");
        semitrailer.setProductionYear(2010L);
        semitrailer.setRegisterNumber("SCI1234");
        semitrailer.setType("silos");

        ArgumentCaptor<Long>argumentCaptor=ArgumentCaptor.forClass(Long.class);
        semitrailerService.delete(semitrailer.getId());


        verify(semitrailerRepository).deleteById(argumentCaptor.capture());
        Long semitrailerId=semitrailer.getId();
        Long semitrailerDeletedId=argumentCaptor.getValue();
        Assertions.assertThat(semitrailerId).isEqualTo(semitrailerDeletedId);

    }

    @Test
    public void shouldShowAll() {
        List<Semitrailer>semitrailers=List.of(
                new Semitrailer(),
                new Semitrailer(),
                new Semitrailer());

        when(semitrailerRepository.findAll()).thenReturn(semitrailers);
        List<Semitrailer>foundSemitrailers=semitrailerService.showAll();

        assertSame(semitrailers,  foundSemitrailers);

    }

    @Test
    public void shouldShowByIdWhenSemitrailerExist() {
        Semitrailer semitrailer = new Semitrailer();
        semitrailer.setId(2L);

        given(semitrailerRepository.findById(2L)).willReturn(Optional.of(semitrailer));

        Semitrailer foundSemitrailer=semitrailerService.showById(2L);

        Assertions.assertThat(foundSemitrailer).isEqualTo(semitrailer);

    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldShowExceptionWhenSemitrailerDoesntExist(){
        Semitrailer semitrailer = new Semitrailer();
        semitrailer.setId(2L);

        given(semitrailerRepository.findById(3L)).willReturn(Optional.ofNullable(null));

        Semitrailer foundSemitrailer=semitrailerService.showById(3L);
    }
}