package cookies.orderState;

import cookies.Order;

public class MakeState implements State {
    @Override
    public String handle(Order order) {
        return "Making";
    }
}
