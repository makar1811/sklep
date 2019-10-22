package pl.training.cloud.shop.shop.dto;

import lombok.Data;

@Data
public class PaymentDto {

    private String orderId;
    private Double amount;
}
