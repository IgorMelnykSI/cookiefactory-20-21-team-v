package cookies.orderState;

import cookies.Order;

public class FailState implements State {
    @Override
    public String handle(Order order) {
        return "Failed";
    }
}
