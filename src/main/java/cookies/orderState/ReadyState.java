package cookies.orderState;

import cookies.Order;

public class ReadyState implements State {
    @Override
    public String handle(Order order) {
        return "Ready for pick up";
    }
}
