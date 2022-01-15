package pl.edu.wszib.order.api.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

import java.util.Set;

@Value
public class OrderApi {
    @NotBlank
    private final String id;

    @NotEmpty   //TODO po create to może być empty!
    private final Set<@Valid OrderItemApi> items;

    public boolean notContains(final String productId) {
        return !contains(productId);
    }

    public boolean contains(final String productId) {
        return items.stream()
                .anyMatch(item -> item.isProduct(productId));
    }
}
