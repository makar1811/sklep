package pl.training.cloud.shop.shop.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.training.cloud.shop.shop.model.Product;
import pl.training.cloud.shop.shop.model.ResultPage;
import pl.training.cloud.shop.shop.repository.ProductsRepository;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    public void addProduct(Product product) {
        productsRepository.saveAndFlush(product);
    }

    public ResultPage<Product> getUsers(int pageNumber, int pageSize) {
        Page<Product> productsPage = productsRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return new ResultPage<>(productsPage.getContent(), productsPage.getNumber(), productsPage.getTotalPages());
    }
}
