package pl.coderslab.service;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.coderslab.dto.OrderDtoNew;
import pl.coderslab.dtoread.OrderDtoReadNew;
import pl.coderslab.model.Cargo;
import pl.coderslab.model.LoadingPlace;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    NewOrderNumberGenerator newOrderNumberGenerator;

    @InjectMocks
    OrderService orderService;

    @Test
    public void shouldDeleteIfExist() {
        Order order = new Order();
        order.setId(10L);
        given(orderRepository.findById(10L)).
                willReturn(Optional.of(order));
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);

        orderService.delete(10L);

        Mockito.verify(orderRepository).deleteById(argumentCaptor.capture());
        Long correctIdOfDeletedOrder = argumentCaptor.getValue();
        Assertions.assertThat(correctIdOfDeletedOrder).isEqualTo(10L);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldShowExceptionIfYouWantToDeleteNotExistingOrder() {
        Order order = new Order();
        order.setId(10L);
        given(orderRepository.findById(20L)).
                willReturn(Optional.ofNullable(null));

        orderService.delete(20L);
    }

    @Test
    public void shouldAddNewOrder() {
        OrderDtoNew orderDtoNew = new OrderDtoNew();
        orderDtoNew.setStatus("nowe");
        Cargo cargo = new Cargo();
        orderDtoNew.setCargo(cargo);
        LoadingPlace loadingPlace = new LoadingPlace();
        orderDtoNew.setLoadingPlace(loadingPlace);
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

        orderService.addNewOrder(orderDtoNew);

        Mockito.verify(orderRepository, Mockito.times(2)).save(orderArgumentCaptor.capture());
        String addedStatus = orderArgumentCaptor.getValue().getStatus();
        Cargo addedCargo = orderArgumentCaptor.getValue().getCargo();
        LoadingPlace addedLoadingPlace = orderArgumentCaptor.getValue().
                getLoadingPlace();

        Assert.assertSame(addedStatus, "nowe");
        Assert.assertSame(addedCargo, cargo);
        Assert.assertSame(addedLoadingPlace, loadingPlace);
    }

    @Test
    public void updateNewOrder() {
        OrderDtoReadNew orderDtoNew = new OrderDtoReadNew();
        orderDtoNew.setStatus("nowe");
        Cargo cargo = new Cargo();
        orderDtoNew.setCargo(cargo);
        LoadingPlace loadingPlace = new LoadingPlace();
        orderDtoNew.setLoadingPlace(loadingPlace);
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

        orderService.updateNewOrder(orderDtoNew);

        Mockito.verify(orderRepository).save(orderArgumentCaptor.capture());
        String addedStatus = orderArgumentCaptor.getValue().getStatus();
        Cargo addedCargo = orderArgumentCaptor.getValue().getCargo();
        LoadingPlace addedLoadingPlace = orderArgumentCaptor.getValue().
                getLoadingPlace();

        Assert.assertSame(addedStatus, "nowe");
        Assert.assertSame(addedCargo, cargo);
        Assert.assertSame(addedLoadingPlace, loadingPlace);
    }

    @Test
    public void shouldShowAllNewOrders() {
        Order order = new Order();
        order.setStatus("nowe");
        Cargo cargo = new Cargo();
        cargo.setName("cukier");
        order.setCargo(cargo);
        Order order1 = new Order();
        order1.setStatus("nowe");
        Cargo cargo1 = new Cargo();
        cargo1.setName("melasa");
        order1.setCargo(cargo1);
        Order order2 = new Order();
        order2.setStatus("nowe");
        Cargo cargo2 = new Cargo();
        cargo2.setName("mąka");
        order2.setCargo(cargo2);
        List<Order> orders = List.of(order, order1, order2);

        Mockito.when(orderRepository.findAllByStatus("nowe")).thenReturn(orders);

        List<OrderDtoReadNew> orderDtoReadNewList = orderService.showAllNewOrders();
        OrderDtoReadNew orderDtoReadNew = orderDtoReadNewList.get(0);
        String readCargoName = orderDtoReadNew.getCargo().getName();
        OrderDtoReadNew orderDtoReadNew1 = orderDtoReadNewList.get(1);
        String readCargo1Name = orderDtoReadNew1.getCargo().getName();
        OrderDtoReadNew orderDtoReadNew2 = orderDtoReadNewList.get(2);
        String readCargo2Name = orderDtoReadNew2.getCargo().getName();
        Assert.assertSame(readCargoName, "cukier");
        Assert.assertSame(readCargo1Name, "melasa");
        Assertions.assertThat(readCargo2Name).isEqualTo("mąka");

    }

    @Test
    public void shouldShowNewOrderById() {
        Order order = new Order();
        order.setId(3L);
        given(orderRepository.findById(3L)).willReturn(Optional.of(order));

        OrderDtoReadNew foundOrderDtoReadNew = orderService.showNewOrderById(3L).orElseThrow();

        Assert.assertSame(order.getId(), foundOrderDtoReadNew.getId());

    }
}