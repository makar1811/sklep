package pl.training.cloud.shop.shop.dto;

import lombok.Data;

@Data
public class AddToCartDto {

    private String orderId;
    private String productName;
}
