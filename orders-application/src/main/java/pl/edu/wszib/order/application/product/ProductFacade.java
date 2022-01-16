package pl.edu.wszib.order.application.product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import pl.edu.wszib.order.api.product.ProductApi;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class ProductFacade {
    private final ProductRepository productRepository;

    public ProductApi create(final ProductApi productApi) {
        final Product product = Product.create(productApi);
        return productRepository.save(product)
                .toApi();
    }

    public Optional<ProductApi> findById(final ProductId productId) {
        return productRepository.findById(productId)
                .map(Product::toApi);
    }

    public Set<ProductApi> findAll() {
        return productRepository.findAll().stream()
                .map(Product::toApi)
                .collect(Collectors.toSet());
    }
}
