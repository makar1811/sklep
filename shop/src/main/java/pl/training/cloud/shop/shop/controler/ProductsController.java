package pl.training.cloud.shop.shop.controler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.cloud.shop.shop.dto.PageDto;
import pl.training.cloud.shop.shop.dto.ProductDto;
import pl.training.cloud.shop.shop.model.Mapper;
import pl.training.cloud.shop.shop.model.Product;
import pl.training.cloud.shop.shop.model.ResultPage;
import pl.training.cloud.shop.shop.services.ProductsService;

import java.net.URI;
import java.util.List;

@RequestMapping(value = "products")
@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final Mapper mapper;
    private UriBuilder uriBuilder = new UriBuilder();

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody ProductDto productDto) {
        Product product = mapper.map(productDto, Product.class);
        productsService.addProduct(product);
        URI uri = uriBuilder.requestUriWithId(product.getId());
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public PageDto<ProductDto> getUsers(
            @RequestParam(required = false, defaultValue = "0", name = "pageNumber") int pageNumber,
            @RequestParam(required = false, defaultValue = "10", name = "pageSize") int pageSize) {
        ResultPage<Product> resultPage = productsService.getUsers(pageNumber, pageSize);
        List<ProductDto> productsDtos = mapper.map(resultPage.getContent(), ProductDto.class);
        return new PageDto<>(productsDtos, resultPage.getPageNumber(), resultPage.getTotalPages());
    }
}
