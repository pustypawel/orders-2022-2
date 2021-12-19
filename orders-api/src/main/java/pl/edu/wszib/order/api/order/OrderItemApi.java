package pl.edu.wszib.order.api.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Value
public class OrderItemApi {
    @NotBlank
    private final String productId;

    @NotNull
    @Length(min = 2, max = 50)
    private final String name;

    @NotNull
    @Positive
    private final BigDecimal price;

    @NotNull
    @Positive
    private final Integer quantity;

    public boolean isProduct(final String productId) {
        return this.productId.equals(productId);
    }
}
