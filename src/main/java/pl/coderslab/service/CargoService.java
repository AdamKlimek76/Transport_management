package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Cargo;
import pl.coderslab.repository.CargoRepository;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService implements CrudService<Cargo> {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public void add(Cargo cargo) {
        cargoRepository.save(cargo);

    }

    @Override
    public void update(Cargo cargo) {
        cargoRepository.save(cargo);

    }

    @Override
    public void delete(long id) {
        cargoRepository.findById(id).orElseThrow(EntityExistsException::new);
        cargoRepository.deleteById(id);
    }

    @Override
    public List<Cargo> showAll() {
        return cargoRepository.findAll();
    }

    @Override
    public Optional<Cargo> showById(long id) {
        return cargoRepository.findById(id);
    }
}
