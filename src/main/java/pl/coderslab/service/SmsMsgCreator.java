package pl.coderslab.service;

import org.springframework.stereotype.Component;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;

@Component
public class SmsMsgCreator implements SmsMessageCreator {

    private final OrderRepository orderRepository;

    public SmsMsgCreator(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String createSmsMsgWithFullDetails(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
        String message = "Załadunek w " +
                order.getLoadingPlace().getCompany() + " " +
                order.getLoadingPlace().getPostCode() + " " +
                order.getLoadingPlace().getPlace() + " w dniu " +
                order.getLoadingDate().toString() + " " + " o godz. " +
                order.getLoadingHour().toString() + ". " +
                "Rozładunek w " +
                order.getUnloadingPlace().getCompany() + " " +
                order.getUnloadingPlace().getPostCode() + " " +
                order.getUnloadingPlace().getPlace() + " w dniu " +
                order.getDeliveryDate().toString() + " " + " o godz. " +
                order.getDeliveryHour().toString() + ". " +
                "Ładunek " + order.getCargo().getName() + ". " +
                "Nr zlecenia: " + order.getOrderNumber() + ".";

        return message;
    }

    @Override
    public String createSmsMsgWithAliasDetails(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
        String message = order.getLoadingPlace().getAlias() + " " +
                order.getLoadingDate() + " " + order.getLoadingHour() +
                " - " + order.getUnloadingPlace().getAlias() + " " +
                order.getDeliveryDate() + " " + order.getDeliveryHour() + ". " +
                "Ład. " + order.getCargo().getName() + ". " +
                "Nr zlec.: " + order.getOrderNumber() + ".";

        return message;
    }
}
