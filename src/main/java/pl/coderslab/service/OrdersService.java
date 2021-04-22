package pl.coderslab.service;

import pl.coderslab.dto.OrderNewDto;
import pl.coderslab.dtoread.OrderReadNewDto;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    void addNewOrder(OrderNewDto newOrder);

    void updateNewOrder(OrderReadNewDto newOrder);

    List<OrderReadNewDto> showAllNewOrders();

    Optional<OrderReadNewDto> showNewOrderById(long id);

}
