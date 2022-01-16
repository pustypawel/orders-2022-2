package pl.edu.wszib.order.application.product;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(final ProductId id);

    Set<Product> findAll();
}
