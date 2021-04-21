package pl.coderslab.service;

import pl.coderslab.dto.OrderNewDto;
import pl.coderslab.dto.OrderToBookDto;
import pl.coderslab.dtoread.OrderReadDto;
import pl.coderslab.dtoread.OrderReadNewDto;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    void addNewOrder(OrderNewDto newOrder);

    void updateNewOrder(OrderReadNewDto newOrder);

    List<OrderReadNewDto> showAllNewOrders();

    Optional<OrderReadNewDto> showNewOrderById(long id);

    OrderToBookDto showOrderToBookById(long id);

    void bookNewOrder(OrderToBookDto bookedOrder);

    List<OrderReadDto>showAllBookedOrders();

    void changeBookedOrder(OrderReadDto bookedOrder);

    List<OrderReadDto>showAllDoneOrders();

    List<OrderReadDto>showAllOrders();

    List<OrderReadDto>sortDoneOrders(String columnName, String sortOrder);

    List<OrderReadDto>searchDoneOrders(String columnName, String searchedText);

    List<OrderReadDto>searchBookedOrders(String searchedText);

}
