package cookies.order;

import cookies.Order;

public class DeliveryState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is under delivery");
        return "Delivering";
    }
}
