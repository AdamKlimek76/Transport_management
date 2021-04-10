package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements MethodsService<Order>, OrderServiceMethods {


    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public void add(Order newOrder) {
        orderRepository.save(newOrder);

    }

    @Override
    public void update(Order newOrder) {
        orderRepository.save(newOrder);

    }

    @Override
    public void delete(long id) {
        orderRepository.findById(id).orElseThrow(EntityExistsException::new);
        orderRepository.deleteById(id);

    }

    @Override
    public List<Order> showAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> showById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public String generateNewOrderNumber() {
        int digitsNumber = showIdOfNewOrder().toString().length();
        int numbersOfZero = 5 - digitsNumber;
        return "ZL" + "0".repeat(Math.max(0, numbersOfZero)) + showIdOfNewOrder().toString();
    }

    @Override
    public Long showIdOfNewOrder() {
        Order order = orderRepository.findLastOrder().orElseThrow(EntityExistsException::new);
        return order.getId();
    }
}
