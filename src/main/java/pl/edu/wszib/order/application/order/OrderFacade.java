package pl.edu.wszib.order.application.order;

import lombok.AllArgsConstructor;
import pl.edu.wszib.order.application.product.ProductFacade;
import pl.edu.wszib.order.application.product.ProductId;

import java.util.Optional;

@AllArgsConstructor
public class OrderFacade {
    private final OrderRepository orderRepository;
    private final ProductFacade productFacade;

    public Order create() {
        final Order order = Order.create();
        return orderRepository.save(order);
    }

    public Optional<Order> findById(final OrderId id) {
        return orderRepository.findById(id);
    }

    public Optional<Order> addItem(final OrderId orderId,
                                   final ProductId productId,
                                   final Integer quantity) {
        return orderRepository.findById(orderId)
                .map(order -> order.addItem(null)); //TODO Impl
    }
}
