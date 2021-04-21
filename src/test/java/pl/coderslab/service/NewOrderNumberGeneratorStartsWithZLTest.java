package pl.coderslab.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.coderslab.model.Cargo;
import pl.coderslab.model.Order;
import pl.coderslab.repository.OrderRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class NewOrderNumberGeneratorStartsWithZLTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    NewOrderNumberGeneratorStartsWithZL orderNumberGenerator;

    @Test
    public void shouldShowIdOfNewOrder() {
        //given
        Order order=new Order();
        order.setStatus("nowe");
        Cargo cargo=new Cargo();
        cargo.setName("cukier");
        order.setCargo(cargo);
        order.setId(2L);
        given(orderRepository.findLastOrder()).willReturn(Optional.of(order));

        //when
        Long newOrderId=orderNumberGenerator.showIdOfNewOrder();

        //then
        Assertions.assertThat(newOrderId).isEqualTo(2L);
    }

    @Test
    public void shouldGenerateCorrectNewOrderNumberIfIdHasOneDigit() {
        //given
        Order order = new Order();
        order.setId(2L);
        given(orderRepository.findLastOrder()).willReturn(Optional.of(order));

        //when
        String newOrderNumber=orderNumberGenerator.generateNewOrderNumber();

        //then
        Assertions.assertThat(newOrderNumber).isEqualTo("ZL00002");
    }

    @Test
    public void shouldGenerateCorrectNewOrderNumberIfIdHasTwoDigits() {
        //given
        Order order = new Order();
        order.setId(25L);
        given(orderRepository.findLastOrder()).willReturn(Optional.of(order));

        //when
        String newOrderNumber=orderNumberGenerator.generateNewOrderNumber();

        //then
        Assertions.assertThat(newOrderNumber).isEqualTo("ZL00025");
    }

    @Test
    public void shouldGenerateCorrectNewOrderNumberIfIdHasThreeDigits() {
        //given
        Order order = new Order();
        order.setId(956L);
        given(orderRepository.findLastOrder()).willReturn(Optional.of(order));

        //when
        String newOrderNumber=orderNumberGenerator.generateNewOrderNumber();

        //then
        Assertions.assertThat(newOrderNumber).isEqualTo("ZL00956");
    }


    @Test
    public void shouldGenerateCorrectNewOrderNumberIfIdHasFourDigits() {
        //given
        Order order = new Order();
        order.setId(1234L);
        given(orderRepository.findLastOrder()).willReturn(Optional.of(order));

        //when
        String newOrderNumber=orderNumberGenerator.generateNewOrderNumber();

        //then
        Assertions.assertThat(newOrderNumber).isEqualTo("ZL01234");
    }

    @Test
    public void shouldGenerateCorrectNewOrderNumberIfIdHasFiveDigits() {
        //given
        Order order = new Order();
        order.setId(99999L);
        given(orderRepository.findLastOrder()).willReturn(Optional.of(order));

        //when
        String newOrderNumber=orderNumberGenerator.generateNewOrderNumber();

        //then
        Assertions.assertThat(newOrderNumber).isEqualTo("ZL99999");
    }
}