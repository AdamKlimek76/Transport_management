package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
