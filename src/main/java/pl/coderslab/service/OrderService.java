package pl.coderslab.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.OrderNewDto;
import pl.coderslab.dto.OrderToBookDto;
import pl.coderslab.dtoread.OrderReadDto;
import pl.coderslab.dtoread.OrderReadNewDto;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService implements CrudService<Order>, OrdersService {


    private final OrderRepository orderRepository;
    private final NewOrderNumberGenerator newOrderNumberGenerator;

    private final static Logger log = LoggerFactory.getLogger(OrderService.class);

    public OrderService(OrderRepository orderRepository, NewOrderNumberGenerator newOrderNumberGenerator) {
        this.orderRepository = orderRepository;
        this.newOrderNumberGenerator = newOrderNumberGenerator;
    }


    @Override
    public void add(Order order) throws RuntimeException {

    }

    @Override
    public void update(Order newOrder) throws RuntimeException {

    }

    @Override
    public void delete(long id) {
        orderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        orderRepository.deleteById(id);

    }

    @Override
    public List<Order> showAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order showById(long id) {
        return orderRepository.findById(id).
                orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public void addNewOrder(OrderNewDto newOrder) {
        Order orderToAdd = new Order();
        orderToAdd.setStatus("nowe");
        orderToAdd.setCreated(LocalDateTime.now());
        orderToAdd.setLoadingDate(newOrder.getLoadingDate());
        orderToAdd.setLoadingHour(newOrder.getLoadingHour());
        orderToAdd.setLoadingPlace(newOrder.getLoadingPlace());
        orderToAdd.setDeliveryDate(newOrder.getDeliveryDate());
        orderToAdd.setDeliveryHour(newOrder.getDeliveryHour());
        orderToAdd.setUnloadingPlace(newOrder.getUnloadingPlace());
        orderToAdd.setCargo(newOrder.getCargo());
        orderRepository.save(orderToAdd);
        orderToAdd.setOrderNumber(newOrderNumberGenerator.generateNewOrderNumber());
        orderRepository.save(orderToAdd);
        //log.info(orderToAdd.getId().toString());

    }

    @Override
    public void updateNewOrder(OrderReadNewDto updatedOrder) {
        Order orderToUpdate = new Order();
        orderToUpdate.setId(updatedOrder.getId());
        orderToUpdate.setStatus(updatedOrder.getStatus());
        orderToUpdate.setOrderNumber(updatedOrder.getOrderNumber());
        orderToUpdate.setCreated(updatedOrder.getCreated());
        orderToUpdate.setUpdated(LocalDateTime.now());
        orderToUpdate.setLoadingDate(updatedOrder.getLoadingDate());
        orderToUpdate.setLoadingHour(updatedOrder.getLoadingHour());
        orderToUpdate.setLoadingPlace(updatedOrder.getLoadingPlace());
        orderToUpdate.setDeliveryDate(updatedOrder.getDeliveryDate());
        orderToUpdate.setDeliveryHour(updatedOrder.getDeliveryHour());
        orderToUpdate.setUnloadingPlace(updatedOrder.getUnloadingPlace());
        orderToUpdate.setCargo(updatedOrder.getCargo());
        orderRepository.save(orderToUpdate);


    }

    @Override
    public List<OrderReadNewDto> showAllNewOrders() {

        return orderRepository.findAllByStatus("nowe")
                .stream()
                .map(entity -> new OrderReadNewDto(
                        entity.getId(),
                        entity.getStatus(),
                        entity.getCreated(),
                        entity.getUpdated(),
                        entity.getOrderNumber(),
                        entity.getDeliveryDate(),
                        entity.getDeliveryHour(),
                        entity.getLoadingDate(),
                        entity.getLoadingHour(),
                        entity.getLoadingPlace(),
                        entity.getUnloadingPlace(),
                        entity.getCargo()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrderReadNewDto> showNewOrderById(long id) {
        return orderRepository.findById(id)
                .map(entity -> new OrderReadNewDto(
                        entity.getId(),
                        entity.getStatus(),
                        entity.getCreated(),
                        entity.getUpdated(),
                        entity.getOrderNumber(),
                        entity.getDeliveryDate(),
                        entity.getDeliveryHour(),
                        entity.getLoadingDate(),
                        entity.getLoadingHour(),
                        entity.getLoadingPlace(),
                        entity.getUnloadingPlace(),
                        entity.getCargo()));

    }

    @Override
    public OrderToBookDto showOrderToBookById(long id) {
        return orderRepository.findById(id)
                .map(entity -> new OrderToBookDto(
                        entity.getId(),
                        entity.getStatus(),
                        entity.getCreated(),
                        entity.getUpdated(),
                        entity.getOrderNumber(),
                        entity.getDeliveryDate(),
                        entity.getDeliveryHour(),
                        entity.getLoadingDate(),
                        entity.getLoadingHour(),
                        entity.getLoadingPlace(),
                        entity.getUnloadingPlace(),
                        entity.getCargo(),
                        entity.getDriver(),
                        entity.getSemitrailer(),
                        entity.getTruck())).
                        orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void bookNewOrder(OrderToBookDto bookedOrder) {
        Order bookedOrderToSave = new Order();
        bookedOrderToSave.setStatus("w trakcie");
        bookedOrderToSave.setUpdated(LocalDateTime.now());
        bookedOrderToSave.setCargo(bookedOrder.getCargo());
        bookedOrderToSave.setId(bookedOrder.getId());
        bookedOrderToSave.setCreated(bookedOrder.getCreated());
        bookedOrderToSave.setOrderNumber(bookedOrder.getOrderNumber());
        bookedOrderToSave.setUnloadingPlace(bookedOrder.getUnloadingPlace());
        bookedOrderToSave.setDeliveryHour(bookedOrder.getDeliveryHour());
        bookedOrderToSave.setDeliveryDate(bookedOrder.getDeliveryDate());
        bookedOrderToSave.setLoadingPlace(bookedOrder.getLoadingPlace());
        bookedOrderToSave.setLoadingHour(bookedOrder.getLoadingHour());
        bookedOrderToSave.setLoadingDate(bookedOrder.getLoadingDate());
        bookedOrderToSave.setDriver(bookedOrder.getDriver());
        bookedOrderToSave.setSemitrailer(bookedOrder.getSemitrailer());
        bookedOrderToSave.setTruck(bookedOrder.getTruck());
        orderRepository.save(bookedOrderToSave);

    }

    @Override
    public List<OrderReadDto> showAllBookedOrders() {
        List<Order>allBookedOrders=new ArrayList<>();
        allBookedOrders=orderRepository.findAllByStatus("w trakcie");
        return castOrderToOrderReadDto(allBookedOrders);
    }

    @Override
    public void changeBookedOrder(OrderReadDto bookedOrder) {
        Order changedOrder = new Order();
        changedOrder.setStatus(bookedOrder.getStatus());
        changedOrder.setUpdated(LocalDateTime.now());
        changedOrder.setCargo(bookedOrder.getCargo());
        changedOrder.setId(bookedOrder.getId());
        changedOrder.setCreated(bookedOrder.getCreated());
        changedOrder.setOrderNumber(bookedOrder.getOrderNumber());
        changedOrder.setUnloadingPlace(bookedOrder.getUnloadingPlace());
        changedOrder.setDeliveryHour(bookedOrder.getDeliveryHour());
        changedOrder.setDeliveryDate(bookedOrder.getDeliveryDate());
        changedOrder.setLoadingPlace(bookedOrder.getLoadingPlace());
        changedOrder.setLoadingHour(bookedOrder.getLoadingHour());
        changedOrder.setLoadingDate(bookedOrder.getLoadingDate());
        changedOrder.setDriver(bookedOrder.getDriver());
        changedOrder.setSemitrailer(bookedOrder.getSemitrailer());
        changedOrder.setTruck(bookedOrder.getTruck());
        orderRepository.save(changedOrder);
    }

    @Override
    public List<OrderReadDto> showAllDoneOrders() {
        List<Order>doneOrderList=new ArrayList<>();
        doneOrderList=orderRepository.findAllByStatus("zrealizowane");
        return castOrderToOrderReadDto(doneOrderList);
    }

    @Override
    public List<OrderReadDto> showAllOrders() {
        List<Order>allOrders=new ArrayList<>();
        allOrders=orderRepository.findAll();
        return castOrderToOrderReadDto(allOrders);
    }

    @Override
    public List<OrderReadDto> sortDoneOrders(String columnName, String sortOrder) {

        final String STATUS = "zrealizowane";

        List<Order> sortedDoneOrders = new ArrayList<>();
        if (columnName.equals("loadingPlace") && sortOrder.equals("ASC")) {
            sortedDoneOrders = orderRepository.findDoneOrdersOrderByLoadingPlaceCompanyAsc(STATUS);
        } else if (columnName.equals("loadingPlace") && sortOrder.equals("DESC")) {
            sortedDoneOrders = orderRepository.findDoneOrdersOrderByLoadingPlaceCompanyDesc(STATUS);
        } else if (columnName.equals("unloadingPlace") && sortOrder.equals("ASC")) {
            sortedDoneOrders = orderRepository.findDoneOrdersOrderByUnloadingPlaceCompanyAsc(STATUS);
        } else {
            sortedDoneOrders = orderRepository.findDoneOrdersOrderByUnloadingPlaceCompanyDesc(STATUS);
        }

        return castOrderToOrderReadDto(sortedDoneOrders);

    }

    @Override
    public List<OrderReadDto> searchDoneOrders(String columnName, String searchedText) {

        final String STATUS = "zrealizowane";

        List<Order> searchedDoneOrders = new ArrayList<>();
        if (columnName.equals("driver")) {
            searchedDoneOrders = orderRepository.findOrdersByDriverLastName(STATUS, searchedText);
        } else {
            searchedDoneOrders = orderRepository.findOrdersBySemitrailerRegisterNumber(STATUS, searchedText);
        }

        return castOrderToOrderReadDto(searchedDoneOrders);
    }

    @Override
    public List<OrderReadDto> searchBookedOrders(String searchedText) {
        List<Order>foundOrders=new ArrayList<>();
        foundOrders=orderRepository.findAll();
        List<OrderReadDto>foundOrdersDto=castOrderToOrderReadDto(foundOrders);
        List<String>stringsToSearch=new ArrayList<>();

        return foundOrdersDto.stream()
                .filter(entity->entity.getStringToSearchBookedOrders().contains(searchedText.toLowerCase()))
                .collect(Collectors.toList());

    }

    private List<OrderReadDto>castOrderToOrderReadDto(List<Order>orders){
        return orders
                .stream()
                .map(entity -> new OrderReadDto(
                        entity.getId(),
                        entity.getStatus(),
                        entity.getCreated(),
                        entity.getUpdated(),
                        entity.getOrderNumber(),
                        entity.getDeliveryDate(),
                        entity.getDeliveryHour(),
                        entity.getLoadingDate(),
                        entity.getLoadingHour(),
                        entity.getLoadingPlace(),
                        entity.getUnloadingPlace(),
                        entity.getCargo(),
                        entity.getDriver(),
                        entity.getSemitrailer(),
                        entity.getTruck()))
                .collect(Collectors.toList());
    }
}
