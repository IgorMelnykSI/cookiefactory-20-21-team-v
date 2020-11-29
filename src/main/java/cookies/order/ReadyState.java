package cookies.order;

import cookies.Order;

public class ReadyState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is ready for pick up");
        return "Ready for pick up";
    }
}
