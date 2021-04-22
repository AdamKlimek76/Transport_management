package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.persistence.EntityExistsException;

@Component
public class NewOrderNumberGeneratorStartsWithZL implements NewOrderNumberGenerator {

    private final OrderRepository orderRepository;

    public NewOrderNumberGeneratorStartsWithZL(OrderRepository orderRepository) {
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
        final int ALL_DIGITS_IN_ORDER_NUMBER = 5;
        int numbersOfZero = ALL_DIGITS_IN_ORDER_NUMBER - digitsNumber;
        return "ZL" + "0".repeat(Math.max(0, numbersOfZero)) + showIdOfNewOrder().toString();
    }
}
