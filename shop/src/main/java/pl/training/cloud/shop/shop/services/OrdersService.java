package pl.training.cloud.shop.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.training.cloud.shop.shop.model.Order;
import pl.training.cloud.shop.shop.model.OrderStatus;
import pl.training.cloud.shop.shop.model.ResultPage;
import pl.training.cloud.shop.shop.repository.OrdersRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;

    public Order createOrder() {
        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        ordersRepository.saveAndFlush(order);
        return order;
    }

    public Order getOrderByOrderId(String orderId) {
        return ordersRepository.findByOrderId(orderId);
    }

    public ResultPage<Order> getOrders(int pageNumber, int pageSize) {
        Page<Order> ordersPage = ordersRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return new ResultPage<>(ordersPage.getContent(), ordersPage.getNumber(), ordersPage.getTotalPages());
    }
}
