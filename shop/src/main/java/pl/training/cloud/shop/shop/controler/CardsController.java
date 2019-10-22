package pl.training.cloud.shop.shop.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.training.cloud.shop.shop.dto.AddToCartDto;
import pl.training.cloud.shop.shop.services.CardService;

@RequestMapping(value = "cards")
@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addProductToCart(@RequestBody AddToCartDto addToCartDto) {
        cardService.addProduct(addToCartDto.getOrderId(), addToCartDto.getProductName());
        return ResponseEntity.accepted().build();
    }
}
