package pl.coderslab.service;

import pl.coderslab.dto.OrderDtoNew;
import pl.coderslab.dtoread.OrderDtoReadNew;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    void addNewOrder(OrderDtoNew newOrder);

    void updateNewOrder(OrderDtoReadNew newOrder);

    List<OrderDtoReadNew> showAllNewOrders();

    Optional<OrderDtoReadNew> showNewOrderById(long id);

}
