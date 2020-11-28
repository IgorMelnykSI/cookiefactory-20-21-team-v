package cookies.order;

import cookies.Order;

public class WaitState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is waiting for pick up");
        return "Wait for pick up";
    }
}
