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
import pl.coderslab.dto.OrderNewDto;
import pl.coderslab.dtoread.OrderReadNewDto;
import pl.coderslab.model.Cargo;
import pl.coderslab.model.LoadingPlace;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

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
        //given
        Order order = new Order();
        order.setId(10L);
        given(orderRepository.findById(10L)).
                willReturn(Optional.of(order));
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);

        //when
        orderService.delete(10L);

        //then
        Mockito.verify(orderRepository).deleteById(argumentCaptor.capture());
        Long correctIdOfDeletedOrder = argumentCaptor.getValue();
        Assertions.assertThat(correctIdOfDeletedOrder).isEqualTo(10L);
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldShowExceptionIfYouWantToDeleteNotExistingOrder() {
        //given
        Order order = new Order();
        order.setId(10L);
        given(orderRepository.findById(20L)).
                willReturn(Optional.ofNullable(null));

        //when
        orderService.delete(20L);

        //then Exception
    }

    @Test
    public void shouldAddNewOrder() {
        //given
        OrderNewDto orderDtoNew = new OrderNewDto();
        orderDtoNew.setStatus("nowe");
        Cargo cargo = new Cargo();
        orderDtoNew.setCargo(cargo);
        LoadingPlace loadingPlace = new LoadingPlace();
        orderDtoNew.setLoadingPlace(loadingPlace);
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

        //when
        orderService.addNewOrder(orderDtoNew);

        //then
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
        //given
        OrderReadNewDto orderDtoNew = new OrderReadNewDto();
        orderDtoNew.setStatus("nowe");
        Cargo cargo = new Cargo();
        orderDtoNew.setCargo(cargo);
        LoadingPlace loadingPlace = new LoadingPlace();
        orderDtoNew.setLoadingPlace(loadingPlace);
        ArgumentCaptor<Order> orderArgumentCaptor = ArgumentCaptor.forClass(Order.class);

        //when
        orderService.updateNewOrder(orderDtoNew);

        //then
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
        //given
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

        //when
        List<OrderReadNewDto> orderDtoReadNewList = orderService.showAllNewOrders();

        //then
        OrderReadNewDto orderDtoReadNew = orderDtoReadNewList.get(0);
        String readCargoName = orderDtoReadNew.getCargo().getName();
        OrderReadNewDto orderDtoReadNew1 = orderDtoReadNewList.get(1);
        String readCargo1Name = orderDtoReadNew1.getCargo().getName();
        OrderReadNewDto orderDtoReadNew2 = orderDtoReadNewList.get(2);
        String readCargo2Name = orderDtoReadNew2.getCargo().getName();
        Assert.assertSame(readCargoName, "cukier");
        Assert.assertSame(readCargo1Name, "melasa");
        Assertions.assertThat(readCargo2Name).isEqualTo("mąka");

    }

    @Test
    public void shouldShowNewOrderById() {
        //given
        Order order = new Order();
        order.setId(3L);
        given(orderRepository.findById(3L)).willReturn(Optional.of(order));

        //when
        OrderReadNewDto foundOrderDtoReadNew = orderService.showNewOrderById(3L).orElseThrow();

        //then
        Assert.assertSame(order.getId(), foundOrderDtoReadNew.getId());

    }
}