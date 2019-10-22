package pl.training.cloud.shop.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.training.cloud.shop.shop.model.Order;
import pl.training.cloud.shop.shop.model.Product;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CardService {

    private final OrdersService ordersService;
    private final ProductsService productsService;

    @Transactional
    public void addProduct(String orderId, String productName) {
        Order order = ordersService.getOrderByOrderId(orderId);
        Product product = productsService.getProductByName(productName);

        order.getProducts().add(product);
        product.decrementAmount();
    }

}
