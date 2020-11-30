package cookies.orderState;

import cookies.Order;

public class WaitPayState implements State {
    @Override
    public String handle(Order order) {
        return "Waiting for payments";
    }
}
