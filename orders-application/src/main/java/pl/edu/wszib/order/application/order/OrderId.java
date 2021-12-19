package pl.edu.wszib.order.application.order;

import lombok.Value;

import java.util.UUID;

@Value
public class OrderId {
    private final String id;

    public static OrderId create() {
        return new OrderId(UUID.randomUUID().toString());
    }

    public static OrderId of(final String id) {
        return new OrderId(id);
    }

    public String asBasicType() {
        return id;
    }
}
