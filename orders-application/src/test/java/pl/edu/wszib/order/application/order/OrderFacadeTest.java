package pl.edu.wszib.order.application.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.wszib.order.api.order.OrderApi;
import pl.edu.wszib.order.api.order.OrderApiResult;
import pl.edu.wszib.order.application.product.ProductSamples;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderFacadeTest {
    //T1. można utworzyć zamówienie
    //T2. można dodać pozycję do zamówienia
    //T3: można usunąć pozycję z zamówienia
    //T4: można zwiększyć ilość dla pozycji
    //T5. można zmniejszyć ilość dla pozycji
    //T6. minimalna ilość dla pozycji to 1
    //T7. dodanie pozycji przedmiotu, który znajduje się już w zamówieniu powinno skutkować zwiększeniem ilości dla istniejącej pozycji
    //T8. wartość pozycji to cena przedmiotu * ilość
    //T9: wartość zamówienia to suma wartości wszystkich pozycji
    //T10: można ukończyć zamówienie
    //T11. nie można modyfikować ukończonego zamówienia

    private OrderFacade orderFacade;

    @BeforeEach
    public void setUp() {
        orderFacade = new OrderModuleInitialization().getFacade();
    }

    @Test
    public void should_be_able_to_create_order() {
        //given:

        //when:
        final OrderApiResult result = orderFacade.create();

        //then:
        assertNotNull(result);
        assertTrue(result.isSuccess());
        assertNotNull(result.getOrder().getId());
        assertTrue(orderFacade.findById(result.getOrder().getId()).isSuccess());
    }

    @Test
    public void should_be_able_to_add_item_to_order() {
        //given:
        final String orderId = orderFacade.create().getOrder().getId();
        final String productToAdd = ProductSamples.CHOCOLATE.getId();

        //when:
        final OrderApiResult result = orderFacade.addItem(orderId, productToAdd, 1);

        //then:
        assertTrue(result.isSuccess());
        final OrderApi modifiedOrder = result.getOrder();
        assertTrue(modifiedOrder.contains(productToAdd));
        System.out.println(modifiedOrder);
    }

    @Test
    public void should_be_able_to_remove_item_from_order() {
        //given:
        final String orderId = orderFacade.create().getOrder().getId();
        final String productToRemove = ProductSamples.CHOCOLATE.getId();
        assertTrue(orderFacade.addItem(orderId, productToRemove, 1).isSuccess());
        assertTrue(orderFacade.addItem(orderId, ProductSamples.COCA_COLA.getId(), 1).isSuccess());

        //when:
        final OrderApiResult result = orderFacade.removeItem(orderId, productToRemove);

        //then:
        assertTrue(result.isSuccess());
        final OrderApi modifiedOrder = result.getOrder();
        boolean notContains = modifiedOrder.notContains(productToRemove);
        assertTrue(notContains);
    }
}
