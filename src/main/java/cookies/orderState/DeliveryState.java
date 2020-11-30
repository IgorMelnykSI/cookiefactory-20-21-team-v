package cookies.orderState;

import cookies.Order;

public class DeliveryState implements State {
    @Override
    public String handle(Order order) {
        return "Delivering";
    }
}
