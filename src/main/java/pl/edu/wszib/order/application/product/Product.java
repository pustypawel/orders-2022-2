package pl.edu.wszib.order.application.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@AllArgsConstructor
public class Product {
    @Getter
    private final ProductId id;
    private final String name;

    //docelowo powinniśmy skorzystać z:
    //https://github.com/JavaMoney/jsr354-api
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
}
