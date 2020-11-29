package cookies.order;

import cookies.Order;

public class CancelState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is cancelled");
        return "Cancelled";
    }
}
