package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.LoadingPlace;
import pl.coderslab.repository.LoadingPlaceRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LoadingPlaceService implements CrudService<LoadingPlace> {

    private final LoadingPlaceRepository loadingPlaceRepository;

    public LoadingPlaceService(LoadingPlaceRepository loadingPlaceRepository) {
        this.loadingPlaceRepository = loadingPlaceRepository;
    }


    @Override
    public void add(LoadingPlace loadingPlace) {
        loadingPlaceRepository.save(loadingPlace);
    }

    @Override
    public void update(LoadingPlace loadingPlace) {
        loadingPlaceRepository.save(loadingPlace);
    }

    @Override
    public void delete(long id) {
        loadingPlaceRepository.deleteById(id);
    }

    @Override
    public List<LoadingPlace> showAll() {
        return loadingPlaceRepository.findAll();
    }

    @Override
    public LoadingPlace showById(long id) {

        return loadingPlaceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
