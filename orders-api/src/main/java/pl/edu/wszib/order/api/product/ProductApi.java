package pl.edu.wszib.order.api.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Objects;

@Value
public class ProductApi {
    @NotNull
    private final String id;

    @NotNull
    @Length(min = 2, max = 50)
    private final String name;

    //docelowo powinniśmy skorzystać z:
    //https://github.com/JavaMoney/jsr354-api
    @NotNull
    @Positive
    private final BigDecimal price;

    public boolean hasId(final String productId) {
        return Objects.equals(id, productId);
    }
}
