package pl.coderslab.service;

import pl.coderslab.dto.OrderDtoNew;
import pl.coderslab.dto.OrderDtoToBook;
import pl.coderslab.dtoread.OrderDtoRead;
import pl.coderslab.dtoread.OrderDtoReadNew;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    void addNewOrder(OrderDtoNew newOrder);

    void updateNewOrder(OrderDtoReadNew newOrder);

    List<OrderDtoReadNew> showAllNewOrders();

    Optional<OrderDtoReadNew> showNewOrderById(long id);

    OrderDtoToBook showOrderToBookById(long id);

    void bookNewOrder(OrderDtoToBook bookedOrder);

    List<OrderDtoRead>showAllBookedOrders();

    void changeBookedOrder(OrderDtoRead bookedOrder);

    List<OrderDtoRead>showAllDoneOrders();

    List<OrderDtoRead>showAllOrders();

}
