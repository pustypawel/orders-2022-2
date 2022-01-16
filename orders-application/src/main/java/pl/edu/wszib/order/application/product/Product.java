package pl.edu.wszib.order.application.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import pl.edu.wszib.order.api.product.ProductApi;

import java.math.BigDecimal;
import java.util.Objects;

@ToString
@AllArgsConstructor
@Getter
class Product {
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

    public static Product create(ProductApi productApi) {
        return create(ProductId.of(productApi.getId()),
                productApi.getName(),
                productApi.getPrice());
    }

    public boolean hasId(final ProductId productId) {
        return Objects.equals(this.id, productId);
    }

    public ProductApi toApi() {
        return new ProductApi(id.asBasicType(), name, price);
    }
}
