package cookies.order;

import cookies.order.State;

public class ConfirmState implements State {
    @Override
    public String handle() {
        System.out.println("The order is confirmed");
        return "Confimed";
    }
}
