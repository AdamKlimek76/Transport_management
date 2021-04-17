package pl.coderslab.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.coderslab.dto.OrderDtoNew;
import pl.coderslab.dtoread.OrderDtoReadNew;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
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
    public void addNewOrder(OrderDtoNew newOrder) {
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
    public void updateNewOrder(OrderDtoReadNew updatedOrder) {
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
    public List<OrderDtoReadNew> showAllNewOrders() {

        return orderRepository.findAllByStatus("nowe")
                .stream()
                .map(entity -> new OrderDtoReadNew(
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
    public Optional<OrderDtoReadNew> showNewOrderById(long id) {
        return orderRepository.findById(id)
                .map(entity -> new OrderDtoReadNew(
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
}
