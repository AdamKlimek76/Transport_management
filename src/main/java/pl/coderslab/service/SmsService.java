package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.dto.SmsDto;
import pl.coderslab.dtoread.SmsReadDto;
import pl.coderslab.model.Order;
import pl.coderslab.model.Sms;
import pl.coderslab.repository.OrderRepository;
import pl.coderslab.repository.SmsRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SmsService implements SmsesService {

    private final SmsRepository smsRepository;
    private final SmsMessageCreator smsMessageCreator;
    private final OrderRepository orderRepository;

    public SmsService(SmsRepository smsRepository, SmsMessageCreator smsMessageCreator, OrderRepository orderRepository) {
        this.smsRepository = smsRepository;
        this.smsMessageCreator = smsMessageCreator;
        this.orderRepository = orderRepository;
    }

    @Override
    public void addSms(SmsDto smsDto) {
        Sms sms=new Sms();
        sms.setCreated(LocalDateTime.now());
        sms.setMessage(smsDto.getMessage());
        sms.setDriver(smsDto.getDriver());

        smsRepository.save(sms);

    }

    @Override
    public List<SmsReadDto> showAllSms() {
        return smsRepository.findAll().stream()
                .map(entity->new SmsReadDto(
                        entity.getId(),
                        entity.getCreated(),
                        entity.getMessage(),
                        entity.getDriver()))
                        .collect(Collectors.toList());
    }

    @Override
    public SmsDto showSmsSendFullForm(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
        SmsDto smsDto = new SmsDto();
        smsDto.setDriver(order.getDriver());
        smsDto.setMessage(smsMessageCreator.createSmsMsgWithFullDetails(orderId));

        return smsDto;
    }

    @Override
    public SmsDto showSmsSendAliasForm(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
        SmsDto smsDto = new SmsDto();
        smsDto.setDriver(order.getDriver());
        smsDto.setMessage(smsMessageCreator.createSmsMsgWithAliasDetails(orderId));

        return smsDto;
    }

    @Override
    public void delete(Long id) {
        smsRepository.deleteById(id);
    }
}
