package pl.edu.wszib.order.consoleui;

import pl.edu.wszib.order.api.order.OrderApi;
import pl.edu.wszib.order.api.order.OrderApiResult;
import pl.edu.wszib.order.api.product.ProductApi;
import pl.edu.wszib.order.application.order.OrderFacade;
import pl.edu.wszib.order.application.product.ProductFacade;

import java.util.Optional;
import java.util.Set;

class OrderMenuController {
    private final OrderMenuView view;
    private final OrderFacade orderFacade;
    private final ProductFacade productFacade;

    public OrderMenuController(final OrderMenuView view,
                               final OrderFacade orderFacade,
                               final ProductFacade productFacade) {
        this.view = view;
        this.orderFacade = orderFacade;
        this.productFacade = productFacade;
    }

    Optional<OrderApiResult> handle(final OrderMenuOption option) {
        OrderApiResult result;
        switch (option) {
            case CREATE_ORDER:
                result = createOrder();
                break;
            case GET_ORDER:
                result = getOrder();
                break;
            case ADD_ITEM_TO_ORDER:
                result = addItem();
                break;
            case REMOVE_ITEM_FROM_ORDER:
                result = removeItem();
                break;
            case EXIT:
                result = null;
                exit();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
        return Optional.ofNullable(result);
    }

    private OrderApiResult createOrder() {
        return orderFacade.create();
    }

    private OrderApiResult getOrder() {
        final String orderId = view.getOrderId();
        return orderFacade.findById(orderId);
    }

    private OrderApiResult addItem() {
        final String orderId = view.getOrderId();
        final Set<ProductApi> products = productFacade.findAll();
        final String productId = view.getProduct(products);
        return orderFacade.addItem(orderId, productId, 1); //TODO quantity
    }

    private OrderApiResult removeItem() {
        final String orderId = view.getOrderId();
        final OrderApiResult result = orderFacade.findById(orderId);
        if (result.isSuccess()) {
            final OrderApi order = result.getOrder();
            final Set<ProductApi> products = order.getProducts();
            final String productId = view.getProduct(products);
            return orderFacade.removeItem(orderId, productId);
        }
        return result;
    }

    private void exit() {
        view.sayGoodbye();
    }
}
