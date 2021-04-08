package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Semitrailer;

public interface SemitrailerRepository extends JpaRepository<Semitrailer,  Long> {
}
