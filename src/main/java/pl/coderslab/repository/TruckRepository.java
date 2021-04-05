package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long> {



}
