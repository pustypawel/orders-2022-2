package pl.edu.wszib.order.api.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;
import pl.edu.wszib.order.api.product.ProductApi;

@Value
public class OrderItemApi {
    @NotNull
    private final ProductApi product;

    @NotNull
    @Positive
    private final Integer quantity;

    public boolean isProduct(final String productId) {
        return this.product.hasId(productId);
    }
}
