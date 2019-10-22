package pl.training.cloud.shop.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.cloud.shop.shop.model.Order;
import pl.training.cloud.shop.shop.model.Product;

public interface OrdersRepository extends JpaRepository<Order, Long> {

    Order findByOrderId(String orderId);
}
