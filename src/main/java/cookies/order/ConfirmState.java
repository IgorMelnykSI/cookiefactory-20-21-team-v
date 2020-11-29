package cookies.order;

import cookies.Order;

public class ConfirmState implements State {
    @Override
    public String handle(Order order) {
        System.out.println("The order is payed and confirmed");
        return "Confirmed";
    }
}
