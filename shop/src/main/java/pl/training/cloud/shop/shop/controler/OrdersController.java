package pl.training.cloud.shop.shop.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.training.cloud.shop.shop.dto.OrderDto;
import pl.training.cloud.shop.shop.dto.PageDto;
import pl.training.cloud.shop.shop.model.Mapper;
import pl.training.cloud.shop.shop.model.Order;
import pl.training.cloud.shop.shop.model.ResultPage;
import pl.training.cloud.shop.shop.services.OrdersService;

import java.util.List;

@RequestMapping(value = "orders")
@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;
    private final Mapper mapper;

    @RequestMapping(method = RequestMethod.POST)
    public OrderDto createOrder() {
        Order order = ordersService.createOrder();
        return mapper.map(order, OrderDto.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageDto<OrderDto> getOrders(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<Order> resultPage = ordersService.getOrders(pageNumber, pageSize);
        List<OrderDto> ordersDtos = mapper.map(resultPage.getContent(), OrderDto.class);
        return new PageDto<>(ordersDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
}
