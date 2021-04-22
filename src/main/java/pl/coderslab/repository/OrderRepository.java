package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value="select * from orders order by id desc limit 1", nativeQuery = true)
    Optional<Order>findLastOrder();

    @Query("SELECT o FROM Order o WHERE o.status LIKE 'nowe'")
    List<Order>findNewOrders();


}
