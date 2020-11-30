package cookies.orderState;

import cookies.Order;

public class CancelState implements State {
    @Override
    public String handle(Order order) {
        return "Cancelled";
    }
}
