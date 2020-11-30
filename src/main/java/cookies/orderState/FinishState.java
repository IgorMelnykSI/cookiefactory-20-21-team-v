package cookies.orderState;

import cookies.Order;

public class FinishState implements State {
    @Override
    public String handle(Order order) {
        return "Finished";
    }
}
