package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Order;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value="select * from new_orders order by id desc limit 1", nativeQuery = true)
    Optional<Order>findLastOrder();


}
