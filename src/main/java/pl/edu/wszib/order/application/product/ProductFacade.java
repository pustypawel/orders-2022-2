package pl.edu.wszib.order.application.product;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ProductFacade {
    private final ProductRepository productRepository;

    public Product create(final Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(final ProductId productId) {
        return productRepository.findById(productId);
    }
}
