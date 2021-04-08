package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.UnloadingPlace;

public interface UnloadingPlaceRepository extends JpaRepository<UnloadingPlace, Long> {
}
