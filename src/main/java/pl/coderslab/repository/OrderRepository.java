package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "select * from orders order by id desc limit 1", nativeQuery = true)
    Optional<Order> findLastOrder();

    List<Order> findAllByStatus(String status);

    @Query(value = "select * from orders join loading_places lp on orders.loadingPlace_id = lp.id join unloading_places up on orders.unloadingPlace_id = up.id where status =?1 order by lp.company ASC",
            nativeQuery = true)
    List<Order> findDoneOrdersOrderByLoadingPlaceCompanyAsc(String status);

    @Query(value = "select * from orders join loading_places lp on orders.loadingPlace_id = lp.id join unloading_places up on orders.unloadingPlace_id = up.id where status =?1 order by lp.company DESC",
            nativeQuery = true)
    List<Order> findDoneOrdersOrderByLoadingPlaceCompanyDesc(String status);


    @Query(value = "select * from orders join loading_places lp on orders.loadingPlace_id = lp.id join unloading_places up on orders.unloadingPlace_id = up.id where status =?1 order by up.company ASC",
            nativeQuery = true)
    List<Order> findDoneOrdersOrderByUnloadingPlaceCompanyAsc(String status);


    @Query(value = "select * from orders join loading_places lp on orders.loadingPlace_id = lp.id join unloading_places up on orders.unloadingPlace_id = up.id where status =?1 order by up.company DESC",
            nativeQuery = true)
    List<Order> findDoneOrdersOrderByUnloadingPlaceCompanyDesc(String status);


    @Query(value = "select o from Order o join o.driver d join o.semitrailer s  where o.status = :status and d.lastName like concat('%', :driverLastName, '%')")
    List<Order> findOrdersByDriverLastName(@Param("status") String status, @Param("driverLastName") String driverLastName);

    @Query(value = "select o from Order o join o.driver d join o.semitrailer s  where o.status = :status and s.registerNumber like concat('%', :semitrailerRegisterNumber, '%')")
    List<Order> findOrdersBySemitrailerRegisterNumber(@Param("status") String status,
                                                      @Param("semitrailerRegisterNumber") String semitrailerRegisterNumber);

}