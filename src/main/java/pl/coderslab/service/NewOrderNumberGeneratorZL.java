package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.persistence.EntityExistsException;

@Component
public class NewOrderNumberGeneratorZL implements NewOrderNumberGenerator {

    private final OrderRepository orderRepository;

    public NewOrderNumberGeneratorZL(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Long showIdOfNewOrder() {
        Order order = orderRepository.findLastOrder().orElseThrow(EntityExistsException::new);
        return order.getId();
    }

    @Override
    public String generateNewOrderNumber() {
        int digitsNumber = showIdOfNewOrder().toString().length();
        int numbersOfZero = 5 - digitsNumber;
        return "ZL" + "0".repeat(Math.max(0, numbersOfZero)) + showIdOfNewOrder().toString();
    }
}
