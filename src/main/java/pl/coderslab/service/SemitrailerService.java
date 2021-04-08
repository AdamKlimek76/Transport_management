package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Semitrailer;
import pl.coderslab.repository.SemitrailerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SemitrailerService implements MethodsService<Semitrailer> {

    private final SemitrailerRepository semitrailerRepository;

    public SemitrailerService(SemitrailerRepository semitrailerRepository) {
        this.semitrailerRepository = semitrailerRepository;
    }


    @Override
    public void add(Semitrailer semitrailer) {
        semitrailerRepository.save(semitrailer);
    }

    @Override
    public void update(Semitrailer semitrailer) {
        semitrailerRepository.save(semitrailer);
    }

    @Override
    public void delete(long id) {
        semitrailerRepository.deleteById(id);
    }

    @Override
    public List<Semitrailer> showAll() {
        return semitrailerRepository.findAll();
    }

    @Override
    public Optional<Semitrailer> showById(long id) {
        return semitrailerRepository.findById(id);
    }
}
