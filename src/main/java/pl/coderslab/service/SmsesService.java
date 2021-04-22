package pl.coderslab.service;

import pl.coderslab.dto.SmsDto;
import pl.coderslab.dtoread.SmsReadDto;
import pl.coderslab.model.Order;

import java.util.List;

public interface SmsesService {

    void addSms(SmsDto smsDto);

    List<SmsReadDto>showAllSms();

    SmsDto showSmsSendFullForm(Long orderId);

    SmsDto showSmsSendAliasForm(Long orderId);

    void delete(Long id);
}
