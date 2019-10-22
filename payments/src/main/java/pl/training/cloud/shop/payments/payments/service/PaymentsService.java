package pl.training.cloud.shop.payments.payments.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pl.training.cloud.shop.payments.payments.model.Payments;

@RequiredArgsConstructor
@Service
@Log
public class PaymentsService {

    @NonNull
    private Source source;

    public Payments addPayment(Payments payments) {
        log.info("Sending payment..");
        Message<String> message = MessageBuilder.withPayload("payments-change").build();
        source.output()
                .send(message);
        return payments;
    }


}