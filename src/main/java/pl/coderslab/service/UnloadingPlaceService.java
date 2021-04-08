package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.UnloadingPlace;
import pl.coderslab.repository.UnloadingPlaceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UnloadingPlaceService implements MethodsService<UnloadingPlace>{

    private final UnloadingPlaceRepository unloadingPlaceRepository;

    public UnloadingPlaceService(UnloadingPlaceRepository unloadingPlaceRepository) {
        this.unloadingPlaceRepository = unloadingPlaceRepository;
    }

    @Override
    public void add(UnloadingPlace unloadingPlace) {
        unloadingPlaceRepository.save(unloadingPlace);
    }

    @Override
    public void update(UnloadingPlace unloadingPlace) {
        unloadingPlaceRepository.save(unloadingPlace);
    }

    @Override
    public void delete(long id) {
        unloadingPlaceRepository.deleteById(id);
    }

    @Override
    public List<UnloadingPlace> showAll() {
        return unloadingPlaceRepository.findAll();
    }

    @Override
    public Optional<UnloadingPlace> showById(long id) {
        return unloadingPlaceRepository.findById(id);
    }
}
