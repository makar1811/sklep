package pl.training.cloud.shop.shop.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Product {

    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;

    public void decrementQuantity() {
        quantity--;
    }
}
