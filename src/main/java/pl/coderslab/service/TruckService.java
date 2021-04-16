package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Truck;
import pl.coderslab.repository.TruckRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TruckService implements CrudService<Truck> {

    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @Override
    public void add(Truck truck) {
        truckRepository.save(truck);
    }

    @Override
    public void update(Truck truck) {
        truckRepository.save(truck);
    }

    @Override
    public void delete(long id) {
        truckRepository.deleteById(id);
    }

    @Override
    public List<Truck> showAll() {

        return truckRepository.findAll();
    }

    @Override
    public Truck showById(long id) {

        return truckRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
