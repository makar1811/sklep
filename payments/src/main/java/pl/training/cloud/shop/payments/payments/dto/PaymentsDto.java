package pl.training.cloud.shop.payments.payments.dto;

import lombok.Data;
import lombok.Generated;
import org.springframework.integration.annotation.IdempotentReceiver;

@Data
public class PaymentsDto {

    private Long paymentId;
    private double amount;
}
