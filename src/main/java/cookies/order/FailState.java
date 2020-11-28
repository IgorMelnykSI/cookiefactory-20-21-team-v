package cookies.order;

import cookies.Order;

public class FailState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is failed");
        return "Failed";
    }
}
