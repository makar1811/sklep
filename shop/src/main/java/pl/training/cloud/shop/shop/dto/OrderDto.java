package pl.training.cloud.shop.shop.dto;

import lombok.Data;
import pl.training.cloud.shop.shop.model.OrderStatus;

import java.util.List;

@Data
public class OrderDto {

    private String orderId;
    private OrderStatus orderStatus;
    private Integer price;

    private List<ProductDto> products;
}
