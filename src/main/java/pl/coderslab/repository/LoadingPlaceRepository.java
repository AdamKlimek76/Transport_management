package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.LoadingPlace;

public interface LoadingPlaceRepository extends JpaRepository<LoadingPlace, Long> {
}
