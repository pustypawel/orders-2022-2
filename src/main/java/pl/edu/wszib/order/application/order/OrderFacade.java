package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import pl.edu.wszib.order.api.order.OrderApi;
import pl.edu.wszib.order.api.order.OrderApiResult;
import pl.edu.wszib.order.api.order.OrderError;
import pl.edu.wszib.order.application.product.Product;
import pl.edu.wszib.order.application.product.ProductFacade;
import pl.edu.wszib.order.application.product.ProductId;

import java.util.Optional;

@AllArgsConstructor
public class OrderFacade {
    private final OrderRepository orderRepository;
    private final ProductFacade productFacade;

    public OrderApi create() {
        final Order order = Order.create();
        return orderRepository.save(order).toApi();
    }

    public Optional<OrderApi> findById(final String id) {
        return findById(OrderId.of(id));
    }

    public Optional<OrderApi> findById(final OrderId id) {
        return orderRepository.findById(id)
                .map(Order::toApi);
    }

    public OrderApiResult addItem(final String orderId,
                                  final ProductId productId,
                                  final Integer quantity) {
        return addItem(OrderId.of(orderId), productId, quantity);
    }

    public OrderApiResult addItem(final OrderId orderId,
                                  final ProductId productId,
                                  final Integer quantity) {
        return orderRepository.findById(orderId)
                .map(order -> addItem(order, productId, quantity))
                .orElseGet(() -> OrderApiResult.failure(OrderError.ORDER_NOT_FOUND));
    }

    private OrderApiResult addItem(final Order order,
                                   final ProductId productId,
                                   final Integer quantity) {
        final Optional<Product> product = productFacade.findById(productId);
        if (product.isPresent()) {
            final OrderItem orderItem = OrderItem.create(product.get(), quantity);
            final Order modifiedOrder = order.addItem(orderItem);
            return OrderApiResult.success(orderRepository.save(modifiedOrder).toApi());
        } else {
            return OrderApiResult.failure(OrderError.PRODUCT_NOT_FOUND);
        }
    }
}
