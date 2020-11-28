package cookies.order;

import cookies.Order;

public class MakeState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is being maked");
        return "Making";
    }
}
