package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Driver;
import pl.coderslab.repository.DriverRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService implements CrudService<Driver> {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void add(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void update(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void delete(long id) {
        driverRepository.deleteById(id);
    }

    @Override
    public List<Driver> showAll() {
        return driverRepository.findAll();
    }

    @Override
    public Driver showById(long id) {
         Optional<Driver> foundDriver = Optional.ofNullable(driverRepository.findById(id)).orElseThrow(EntityNotFoundException::new);
         return foundDriver.orElseThrow();
    }


}
