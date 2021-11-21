package pl.edu.wszib.order.application.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductFacade {
    private final ProductRepository productRepository;

    public Product create(final Product product) {
        return productRepository.save(product);
    }
}
