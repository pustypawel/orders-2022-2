package pl.edu.wszib.order.application.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.util.Objects;

@ToString
@AllArgsConstructor
@Getter
public class Product {
    @NotNull
    private final ProductId id;

    @NotNull
    @Length(min = 2, max = 50)
    private final String name;

    //docelowo powinniśmy skorzystać z:
    //https://github.com/JavaMoney/jsr354-api
    @NotNull
    @Positive
    private final BigDecimal price;

    public static Product create(final ProductId id,
                                 final String name,
                                 final BigDecimal price) {
        return new Product(
                id,
                name,
                price
        );
    }

    public boolean hasId(final ProductId productId) {
        return Objects.equals(this.id, productId);
    }
}
