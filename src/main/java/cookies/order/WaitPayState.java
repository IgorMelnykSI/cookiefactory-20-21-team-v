package cookies.order;

import cookies.Order;

public class WaitPayState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is generated but not payed");
        return "Wait for pay";
    }
}
