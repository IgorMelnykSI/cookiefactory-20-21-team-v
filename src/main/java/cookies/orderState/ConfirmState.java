package cookies.orderState;

import cookies.Order;

public class ConfirmState implements State {
    @Override
    public String handle(Order order) {
        return "Confirmed";
    }
}
