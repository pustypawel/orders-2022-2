package pl.edu.wszib.order.consoleui;

import pl.edu.wszib.order.api.order.OrderApi;
import pl.edu.wszib.order.application.product.Product;
import pl.edu.wszib.order.application.product.ProductId;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

class OrderMenuController {
    private final OrderMenuView view;

    public OrderMenuController(final OrderMenuView view) {
        this.view = view;
    }

    OrderApi handle(final OrderMenuOption option) {
        switch (option) {
            case CREATE_ORDER:
                return createOrder();
            case GET_ORDER:
                return getOrder();
            case ADD_ITEM_TO_ORDER:
                return addItem();
            case REMOVE_ITEM_FROM_ORDER:
                return removeItem();
            case EXIT:
                return exit();
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    private OrderApi createOrder() {
//        final OrderItemApi item = new OrderItemApi(UUID.randomUUID().toString(), "Testowy produkt", BigDecimal.valueOf(10), 1);
        //TODO wywołać logikę aplikacyjną
        return new OrderApi(UUID.randomUUID().toString(), Set.of());
    }

    private OrderApi getOrder() {
        final String orderId = view.getOrderId();
        //TODO odpytać logikę aplikacyjną
        return new OrderApi(UUID.randomUUID().toString(), Set.of());
    }

    private OrderApi addItem() {
        final String orderId = view.getOrderId();
        //TODO wywołać logikę aplikacyjną
        final Product chocolate = Product.create(ProductId.create(),
                "Czekolada",
                BigDecimal.valueOf(4));
        final Product cocaCola = Product.create(ProductId.create(),
                "Coca-cola",
                BigDecimal.valueOf(5));
        final String productId = view.getProduct(Set.of(chocolate, cocaCola));
        //TODO wywołać logikę aplikacyjną
        return new OrderApi(UUID.randomUUID().toString(), Set.of());
    }

    private OrderApi removeItem() {
        //TODO wywołać logikę aplikacyjną
        final String orderId = view.getOrderId();
        //TODO wywołać logikę aplikacyjną
        OrderApi order = new OrderApi(UUID.randomUUID().toString(), Set.of());

        final String productId = view.getProduct(Set.of());
        return order;
    }


    private OrderApi exit() {
        view.sayGoodbye();
        return new OrderApi(UUID.randomUUID().toString(), Set.of());
    }
}
