package pl.training.cloud.shop.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.training.cloud.shop.shop.model.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);
}
