package pl.training.cloud.shop.payments.payments.dto;

import lombok.Data;

@Data
public class PaymentsDto {

    private String orderId;
    private double amount;
}
