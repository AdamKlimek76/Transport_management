package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
