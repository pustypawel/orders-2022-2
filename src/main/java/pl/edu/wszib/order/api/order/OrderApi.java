package pl.edu.wszib.order.api.order;

import lombok.Value;

import java.util.Set;

@Value
public class OrderApi {
    private final String id;
    private final Set<OrderItemApi> items;

    public boolean notContains(final String productId) {
        return !contains(productId);
    }

    public boolean contains(final String productId) {
        return items.stream()
                .anyMatch(item -> item.isProduct(productId));
    }
}
