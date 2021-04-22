package pl.coderslab.service;

import pl.coderslab.model.Order;

public interface SmsMessageCreator {

    String createSmsMsgWithFullDetails(Long orderId);

    String createSmsMsgWithAliasDetails(Long orderId);
}
