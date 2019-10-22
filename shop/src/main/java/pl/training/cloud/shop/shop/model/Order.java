package pl.training.cloud.shop.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    private List<Product> products = new ArrayList<>();
}
