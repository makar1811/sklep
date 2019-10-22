package pl.training.cloud.shop.shop.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order2")
public class Order {

    @GeneratedValue
    @Id
    private Long id;
    private String orderId;
    private Integer price;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
